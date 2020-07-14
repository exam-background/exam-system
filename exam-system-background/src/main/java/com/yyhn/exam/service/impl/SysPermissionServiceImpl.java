package com.yyhn.exam.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yyhn.exam.entity.SysPermission;
import com.yyhn.exam.mapper.SysPermissionMapper;
import com.yyhn.exam.service.SysPermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SysPermissionServiceImpl implements SysPermissionService {

    @Resource
    private SysPermissionMapper sysPermissionMapper;

    @Override
    public boolean addPermission(SysPermission sysPermission) {
        int result = 0;
        result = sysPermissionMapper.insert(sysPermission);
        return result > 0 ? true : false;
    }

    @Override
    public boolean removePermission(Integer id) {
        int result = 0;
        result = sysPermissionMapper.deleteById(id);
        return result > 0 ? true : false;
    }

    @Override
    public boolean updatePermission(SysPermission sysPermission) {
        int result = 0;
        result = sysPermissionMapper.updateById(sysPermission);
        return result > 0 ? true : false;
    }

    @Override
    public SysPermission getPermissionById(Integer id) {
        return sysPermissionMapper.selectById(id);
    }


    @Override
    public List<SysPermission> getPermissionByList( String name) {
        List<SysPermission> sysPermissionList = null;

        if(name== null){
            sysPermissionList = sysPermissionMapper.selectList(new EntityWrapper<SysPermission>().orderBy("id",false));
        }else{
            sysPermissionList = sysPermissionMapper.selectList(new EntityWrapper<SysPermission>()
                    .like(name != null, "permission_name", name)
                    .orderBy("id",false));
        }
        return sysPermissionList;
    }

    @Override
    public List<SysPermission> getPermissionLevel1ByList() {
        return null;
    }
}
