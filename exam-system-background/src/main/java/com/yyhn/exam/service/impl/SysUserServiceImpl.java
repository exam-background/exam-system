package com.yyhn.exam.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yyhn.exam.common.MD5;
import com.yyhn.exam.common.SysUserUtils;
import com.yyhn.exam.common.TokenService;
import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.entity.SysUserDetail;
import com.yyhn.exam.entity.UserHasRole;
import com.yyhn.exam.mapper.SysRoleMapper;
import com.yyhn.exam.mapper.SysUserMapper;
import com.yyhn.exam.mapper.UserHasRoleMapper;
import com.yyhn.exam.service.SysUserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    Logger log = Logger.getLogger(SysUserServiceImpl.class);
    @Autowired
    TokenService tokenService;
   @Autowired
   private PasswordEncoder passwordEncoder;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private UserHasRoleMapper userHasRoleMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Integer getUserIdByUserNameOrPassword(String loginName, String password) {
        return sysUserMapper.getUserIdByUserNameOrPassword(loginName,password);
    }

    @Override
    public Integer getUserIdByUserNameAndPassword(String login_Name, String login_password) {
        System.out.println(login_Name+"--------------"+login_password);
        SysUser sysUser = new SysUser();
        sysUser.setLogin_password(login_password);
        sysUser.setLogin_name(login_Name);
        return sysUserMapper.getUserIdByUserNameAndPassword(sysUser);
    }

    @Override
    public int deleteSysUser(int id) {
        return sysUserMapper.deleteSysUser(id);
    }

    @Override
    public int deleteSysUsers(List<SysUser> list) {
        List<Integer> lists = new ArrayList<Integer>();
        for(SysUser sysUser : list){
            lists.add(sysUser.getId());
        }
        return sysUserMapper.deleteSysUsers(lists);
    }

    @Override
    public int addSysUser(SysUser sysUser) {
        return sysUserMapper.addSysUser(sysUser);
    }

    @Override
    public int updateSysUser(SysUser sysUser) {
        return sysUserMapper.updateSysUser(sysUser);
    }

    @Override
    public List<SysUser> getSysUserByPage(String department, String position, Integer page, Integer pageSize) {
        if(page != null){
            page = (page-1)*pageSize;
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("department", department);
        map.put("position", position);
        map.put("page", page);
        map.put("pageSize", pageSize);
        List<SysUser> sysUserList = null;
        List<SysRole> sysRoleList = new ArrayList<>();

        try {
             sysUserList= sysUserMapper.getSysUserByPage(map);
            System.out.println("sysUserList.size() = " + sysUserList.size());
            for (SysUser user : sysUserList) {
                List<UserHasRole> hasRoleList = userHasRoleMapper.selectList(new EntityWrapper<UserHasRole>()
                        .eq("user_id", user.getId()));//循环获取用户与角色关联的ID
                System.out.println("hasRoleList = " + hasRoleList.toString());
                for (int i = 0; i < hasRoleList.size(); i++) {//将获取到的用户的多个角色进行遍历，获取角色具体信息
                  SysRole sysRole = sysRoleMapper.selectById(hasRoleList.get(i).getRoleId());
                    sysRoleList.add(sysRole);
                }
                user.setRoles(sysRoleList);
                sysRoleList = new ArrayList<>();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return sysUserList;
    }

    @Override
    public String login(String username, String password, HttpServletRequest request) {
        String token = null;
        //密码需要客户端加密后传递
        try {

             SysUserDetail sysUserDetail = (SysUserDetail)userDetailsService.loadUserByUsername(username);

            log.info("输入"+password+"----"+sysUserDetail.getSysUser().getLogin_password());
                if (!passwordEncoder.matches(password, sysUserDetail.getSysUser().getLogin_password())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(sysUserDetail, null, sysUserDetail.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = tokenService.generateToken (request.getHeader("user-agent"),sysUserDetail.getSysUser());

            SysUser sysUser = SysUserUtils.getSysUser();
            // 保存在线信息
            tokenService.save(token, sysUser);

            System.out.println("=============================="+sysUser.getLogin_name());
            //踢掉之前已经登录的token
            String oldToken = "";
            if(stringRedisTemplate.hasKey("online:"+sysUser.getLogin_name())){
                oldToken = stringRedisTemplate.opsForValue().get("online:"+sysUser.getLogin_name());
            }
            if("" != oldToken){
                stringRedisTemplate.delete(oldToken);
            }
           // boolean singleLogin = false;

//            if (singleLogin) {
//
//               // onlineUserService.checkLoginOnUser(sysUser.getUsername(), token);
//            }
        } catch (AuthenticationException e) {
            log.info("登录异常:"+e.getMessage());
        }
        return token;
    }
}
