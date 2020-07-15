package com.yyhn.exam.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.entity.UserHasRole;
import com.yyhn.exam.mapper.SysRoleMapper;
import com.yyhn.exam.mapper.SysUserMapper;
import com.yyhn.exam.mapper.UserHasRoleMapper;
import com.yyhn.exam.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Resource
    private UserHasRoleMapper userHasRoleMapper;

    @Resource
    private SysRoleMapper sysRoleMapper;

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
}
