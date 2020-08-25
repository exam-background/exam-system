package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.UserHasRole;
import com.yyhn.exam.mapper.SysUserRoleMapper;
import com.yyhn.exam.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserRoleServiceImpl implements SysUserRoleService {

    @Resource
    private SysUserRoleMapper sysUserRoleMapper;
    @Override
    public Integer insert(Integer userId,Integer roleId) {
        UserHasRole userHasRole = new UserHasRole();
        userHasRole.setUserId(userId);
        userHasRole.setRoleId(roleId);
        return sysUserRoleMapper.insert(userHasRole);
    }
}
