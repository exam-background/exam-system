package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapperGet {
    @Select("SELECT * FROM exam_sys_user WHERE login_name = #{userName}")
     SysUser getByUserName(String userName);
}
