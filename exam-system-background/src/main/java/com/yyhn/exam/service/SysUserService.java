package com.yyhn.exam.service;

import com.yyhn.exam.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SysUserService {
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public int deleteSysUser(int id);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    public int addSysUser(SysUser sysUser);

    /**
     * 根据条件分页查询
     * @param department
     * @param position
     * @param page
     * @param pageSize
     * @return
     */
    public List<SysUser> getSysUserByPage(String department, String position, Integer page, Integer pageSize);
}
