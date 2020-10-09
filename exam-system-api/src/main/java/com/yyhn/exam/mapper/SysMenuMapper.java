package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SysMenuMapper {
    List<SysMenu> getPermissionList(@Param("userId") int userId);
    List<SysMenu> getAllMenu();

    List<Integer> selectMenuIdListByRoleId(int roleId);

    int deleteRoleMenu(int roleId);
}
