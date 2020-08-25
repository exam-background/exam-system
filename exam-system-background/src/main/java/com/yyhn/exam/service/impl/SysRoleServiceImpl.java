package com.yyhn.exam.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yyhn.exam.entity.RoleHasMenu;
import com.yyhn.exam.entity.RoleHasPermission;
import com.yyhn.exam.entity.SysPermission;
import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.mapper.RoleHasPermissionMapper;
import com.yyhn.exam.mapper.SysPermissionMapper;
import com.yyhn.exam.mapper.SysRoleMapper;
import com.yyhn.exam.service.SysRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleMapper sysRoleMapper;

    @Resource
    private RoleHasPermissionMapper roleHasPermissionMapper;

    @Resource
    private SysPermissionMapper permissionMapper;

    @Override
    public boolean addRoles(SysRole sysRole) {
        int result=0;
        result = sysRoleMapper.insert(sysRole);
        return result > 0 ? true : false;
    }

    @Override
    public boolean removeRoles(Integer id) {
        int result=0;
        result = sysRoleMapper.deleteById(id);
        return result > 0 ? true : false;
    }

    @Override
    public boolean updateRoles(SysRole sysRole) {
        int result=0;
        result = sysRoleMapper.updateById(sysRole);
        return result > 0 ? true : false;
    }

    @Override
    public SysRole getRoleById(Integer id) {
        SysRole sysRole =null;
        try{
        sysRole = sysRoleMapper.selectById(id);
        List<RoleHasPermission> hasPermissionList = roleHasPermissionMapper.selectList(new EntityWrapper<RoleHasPermission>()
                .eq("role_id", id));
        List<SysPermission> sysPermissionList =new ArrayList<>();
        for (RoleHasPermission hasPermission : hasPermissionList) {
            SysPermission sysPermission = permissionMapper.selectById(hasPermission.getPermissionId());
            sysPermissionList.add(sysPermission);
        }
        sysRole.setPermissions(sysPermissionList);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return sysRole;
    }

    @Override
    public List<SysRole> getRoleByList(String roleName) {
        List<SysRole> sysRoleList =null;
        try {
            if(roleName!=null){
                sysRoleList = sysRoleMapper.selectList(new EntityWrapper<SysRole>()
                        .like(roleName!=null,"role_name",roleName).orderBy("id",false));
            }else {
                sysRoleList = sysRoleMapper.selectList(new EntityWrapper<SysRole>().orderBy("id",false));
            }
            for (SysRole sysRole : sysRoleList) {
                List<RoleHasPermission> roleHasPermissionList = roleHasPermissionMapper.selectList(new EntityWrapper<RoleHasPermission>()
                        .eq("role_id", sysRole.getId()));
                List<SysPermission> sysPermissionList =new ArrayList<>();
                for (RoleHasPermission hasPermission : roleHasPermissionList) {
                    SysPermission sysPermission = permissionMapper.selectById(hasPermission.getPermissionId());
                    sysPermissionList.add(sysPermission);
                }
                sysRole.setPermissions(sysPermissionList);
                sysPermissionList = new ArrayList<>();
            }
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }

        return sysRoleList;
    }

    @Override
    public List<SysRole> getUserRolesByUserId(Integer id) {
        return sysRoleMapper.getUserRolesByUserId(id);
    }

    @Override
    public Integer findRoleMarkCount(String roleMark) {
        return sysRoleMapper.findRoleMarkCount(roleMark);
    }

    @Override
    public Integer findRoleNameCount(String roleName) {
        return sysRoleMapper.findRoleNameCount(roleName);
    }

    @Override
    public Integer addRoleMenu(Integer roleId, Integer menuId) {
        RoleHasMenu roleHasMenu = new RoleHasMenu();
        roleHasMenu.setMenuId(menuId);
        roleHasMenu.setRoleId(roleId);
        return sysRoleMapper.addRoleMenu(roleHasMenu);
    }

    @Override
    public Integer getRoleIdByMark(String mark) {
        return sysRoleMapper.getRoleIdByMark(mark);
    }

    @Override
    public Integer findIdByMark(String roleMark) {
        return sysRoleMapper.findIdByMark(roleMark);
    }

    @Override
    public Integer updateUserRole(Integer userId, Integer roleId) {
        return sysRoleMapper.updateUserRole(userId,roleId);
    }
}
