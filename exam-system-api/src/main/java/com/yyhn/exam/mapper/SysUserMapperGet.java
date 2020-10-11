package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapperGet {
     SysUser getByUserName(String userName);
}
