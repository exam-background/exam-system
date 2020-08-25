package com.yyhn.exam.service;

import com.yyhn.exam.entity.SysRole;

import java.util.List;

public interface SysRoleService {

    boolean addRoles(SysRole sysRole);

    boolean removeRoles(Integer id);

    boolean updateRoles(SysRole sysRole);

    SysRole getRoleById(Integer id);

    List<SysRole> getRoleByList(String roleName);

    List<SysRole> getUserRolesByUserId(Integer id);
    Integer findRoleMarkCount(String roleMark);
    Integer findRoleNameCount(String roleName);
    Integer addRoleMenu(Integer roleId , Integer menuId);
    Integer getRoleIdByMark(String mark);
    Integer findIdByMark(String roleMark);
    Integer updateUserRole(Integer userId,Integer roleId);
}
