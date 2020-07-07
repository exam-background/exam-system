package com.yyhn.exam.mapper;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserMapper {
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
     * @param map
     * @return
     */
    public List<SysUser> getSysUserByPage(Map<String, Object> map);
}
