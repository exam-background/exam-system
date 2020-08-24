package com.yyhn.exam.common;


import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.entity.SysUserDetail;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * ClassName: BeanUtils
 * Description: 获取当前登陆用户信息
 *
 * @author honghh
 * Date 2019/08/14 15:00
 * Copyright (C) www.honghh.top
 */
public class SysUserUtils {

    public static SysUser getSysUser() {
        try {
            SecurityContext ctx = SecurityContextHolder.getContext();
            Authentication auth = ctx.getAuthentication();
            SysUserDetail memberDetails = (SysUserDetail) auth.getPrincipal();
            return memberDetails.getSysUser();
        } catch (Exception e) {
            return new SysUser();
        }
    }
}
