package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.mapper.SysUserMapper;
import com.yyhn.exam.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public int deleteSysUser(int id) {
        return sysUserMapper.deleteSysUser(id);
    }

    @Override
    public int deleteSysUsers(List<SysUser> list) {
        List<Integer> lists = new ArrayList<Integer>();
        for(SysUser sysUser : list){
            lists.add(sysUser.getId());
        }
        return sysUserMapper.deleteSysUsers(lists);
    }

    @Override
    public int addSysUser(SysUser sysUser) {
        return sysUserMapper.addSysUser(sysUser);
    }

    @Override
    public int updateSysUser(SysUser sysUser) {
        return sysUserMapper.updateSysUser(sysUser);
    }

    @Override
    public List<SysUser> getSysUserByPage(String department, String position, Integer page, Integer pageSize) {
        if(page != null){
            page = (page-1)*pageSize;
        }
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("department", department);
        map.put("position", position);
        map.put("page", page);
        map.put("pageSize", pageSize);
        return sysUserMapper.getSysUserByPage(map);
    }
}
