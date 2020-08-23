package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.mapper.SysUserMapperGet;
import com.yyhn.exam.service.SysUserServiceGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceGetImpl implements SysUserServiceGet {
    @Resource
    SysUserMapperGet sysUserMapperGet;
    @Override
    public SysUser getByUserName(String userName) {
        return sysUserMapperGet.getByUserName(userName);
    }
}
