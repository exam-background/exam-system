package com.yyhn.exam.service;

import com.yyhn.exam.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    boolean addRoles(SysRole sysRole);

    boolean removeRoles(Integer id);

    boolean updateRoles(SysRole sysRole);

    SysRole getRoleById(Integer id);

    List<SysRole> getRoleByList(String roleName);


}
