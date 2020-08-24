package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    List<SysMenu> getPermissionList(@Param("userId") int userId);
    @Select("select * from exam_menu")
    List<SysMenu> getAllMenu();
}
