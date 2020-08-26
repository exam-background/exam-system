package com.yyhn.exam.service;

import com.yyhn.exam.entity.SysMenu;

import java.util.List;

public interface SysMenuService {

    List<SysMenu> selectMenuList(int userId);

    List<Integer> selectMenuIdListByRoleId(int roleId);

    List<SysMenu> selectMenuList(SysMenu sysMenu,int userId);
    List<SysMenu> getAllMenu();

    int deleteRoleMenu(int roleId);
}
