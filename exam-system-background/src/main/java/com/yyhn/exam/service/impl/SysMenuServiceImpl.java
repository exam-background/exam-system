package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.SysMenu;
import com.yyhn.exam.mapper.SysMenuMapper;
import com.yyhn.exam.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class SysMenuServiceImpl implements SysMenuService {
    @Resource
    private SysMenuMapper sysMenuMapper;

    @Override
    public List<SysMenu> selectMenuList(int userId) {
        return selectMenuList(new SysMenu(), userId);
    }

    @Override
    public List<SysMenu> selectMenuList(SysMenu menu, int userId) {
        List<SysMenu> menuList = null;
            menuList = sysMenuMapper.getPermissionList(userId);
        return menuList;
    }

    @Override
    public List<SysMenu> getAllMenu() {
        return sysMenuMapper.getAllMenu();
    }
}
