package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.UserHasRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper {

    @Insert("insert into exam_user_role(user_id,role_id) values(#{userId},#{roleId})")
    Integer insert(Integer userId,Integer roleId);
}
