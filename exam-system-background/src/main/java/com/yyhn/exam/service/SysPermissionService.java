package com.yyhn.exam.service;

import com.yyhn.exam.entity.SysPermission;

import java.util.List;

public interface SysPermissionService {

    boolean addPermission(SysPermission sysPermission);

    boolean removePermission(Integer id);

    boolean updatePermission(SysPermission sysPermission);

    SysPermission getPermissionById(Integer id);

    List<SysPermission> getPermissionByList(String name);

    List<SysPermission> getPermissionLevel1ByList();

}
