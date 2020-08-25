package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.UserHasRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysUserRoleMapper {

    Integer insert(UserHasRole userHasRole);
}
