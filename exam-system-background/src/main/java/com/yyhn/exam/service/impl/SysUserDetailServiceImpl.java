package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.SysMenu;
import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.entity.SysUserDetail;
import com.yyhn.exam.service.SysMenuService;
import com.yyhn.exam.service.SysRoleService;
import com.yyhn.exam.service.SysUserServiceGet;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SysUserDetailServiceImpl implements UserDetailsService {
    @Resource
    private SysUserServiceGet sysUserServiceGet;
    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private SysRoleService sysRoleService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取登录用户信息
        SysUser user = sysUserServiceGet.getByUserName(username);

        System.out.println(username+"?????");
        if (null == user) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println(" 获取的密码WEI : " +user.getLogin_password());
        List<SysRole> roles = sysRoleService.getUserRolesByUserId(Integer.valueOf(user.getId()));
        List<SysMenu> permissions = sysMenuService.selectMenuList(user.getId());
        SysUserDetail userDetail = new SysUserDetail(user, permissions);
        userDetail.setRoles(roles);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~"+roles.get(0).getRoleName()+"--"+user.getId());
        return userDetail;
    }
}
