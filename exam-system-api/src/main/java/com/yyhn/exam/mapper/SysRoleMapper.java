package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.RoleHasMenu;
import com.yyhn.exam.entity.SysRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    Integer addRoleMenu(RoleHasMenu roleHasMenu);

    List<SysRole> getUserRolesByUserId(Integer id);

    @Select("SELECT id FROM exam_sys_role WHERE role_mark = #{mark} ")
    Integer getRoleIdByMark(String mark);

    @Select("select count(1) from exam_sys_role where role_mark = #{roleMark}")
    Integer findRoleMarkCount(String roleMark);

    @Select("select count(1) from exam_sys_role where role_name = #{roleName}")
    Integer findRoleNameCount(String roleName);
    @Select("select id from exam_sys_role where role_mark = #{roleMark}")
    Integer findIdByMark(String roleMark);
    @Update("update exam_user_role set role_id = #{roleId} where user_id = #{userId}")
    Integer updateUserRole(Integer userId,Integer roleId);
}
