package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public int deleteSysUser(int id);

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deleteSysUsers(List<Integer> list);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    public int addSysUser(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    public int updateSysUser(SysUser sysUser);

    /**
     * 根据条件分页查询
     * @param map
     * @return
     */
    public List<SysUser> getSysUserByPage(Map<String, Object> map);

    Integer getUserIdByUserNameAndPassword(SysUser sysUser);

    @Select("select id from exam_sys_user where login_Name = #{loginName} or login_password = #{password}")
    Integer getUserIdByUserNameOrPassword(String loginName,String password);
}
