package com.yyhn.exam.service;

import com.yyhn.exam.entity.SysRole;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

public interface SysRoleService {
    Integer findRoleMarkCount(String roleMark);

    Integer findRoleNameCount(String roleName);

    Integer getRoleIdByMark(String mark);

    boolean addRoles(SysRole sysRole);

    boolean removeRoles(Integer id);

    boolean updateRoles(SysRole sysRole);

    SysRole getRoleById(Integer id);

    List<SysRole> getRoleByList(String roleName);

    List<SysRole> getUserRolesByUserId(Integer id);

    Integer addRoleMenu(Integer roleId , Integer menuId);
    Integer findIdByMark(String roleMark);
    Integer updateUserRole(Integer userId,Integer roleId);
}
