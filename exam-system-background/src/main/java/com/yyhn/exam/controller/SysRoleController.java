package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.SysMenu;
import com.yyhn.exam.entity.SysRole;
import com.yyhn.exam.service.SysMenuService;
import com.yyhn.exam.service.SysRoleService;
import com.yyhn.exam.vo.SysRoleSearchVO;
import io.swagger.annotations.Api;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "SysRoleController",description = "用户权限操作")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;


    @PostMapping("/addSysRole")
    public ResultMsg addSysRole(SysRole sysRole){
        if(sysRole== null)return  ResultMsg.BY_NULL("对象为空");
        if (sysRoleService.findRoleNameCount(sysRole.getRoleName())>0){
            return ResultMsg.BY_FAIL("添加失败,已有此名称");
        }
        if(sysRoleService.findRoleMarkCount(sysRole.getRoleMark())>0){
            return ResultMsg.BY_FAIL("添加失败,已有此标识");
        }
        try {
            sysRoleService.addRoles(sysRole);
            return ResultMsg.BY_SUCCESS("添加成功",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.BY_FAIL("添加失败,系统错误");
    }

    @PostMapping("/addRoleMenu")
    public Dto addRoleMenu(int [] menus,String roleMark){
        System.out.println(menus[0]+"-===-=--==-=-·1 "+roleMark);
        Integer roleId = sysRoleService.findIdByMark(roleMark);
        for(int menuId : menus){
            sysRoleService.addRoleMenu(roleId,Integer.valueOf(menuId));
        }
            return DtoUtil.returnSuccess("成功");
    }

    @GetMapping("/getAllMenu")
    public Dto getAllMenu(){
        List<SysMenu> menus = null;
        menus = sysMenuService.getAllMenu();
        if(null != menus){
            return DtoUtil.returnDataSuccess(menus);
        }else{
            return DtoUtil.returnFail("暂无数据","40001");
        }
    }


    @RequestMapping(value = "getSysRoleList",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultMsg getSysRoleListByPage(@RequestParam(value = "roleName",required = false) String roleName){
        List<SysRole> roleByList =null;
        System.out.println("roleName = " + roleName);
        try {
                roleByList = sysRoleService.getRoleByList(roleName);
            if(roleByList.size()>0) return ResultMsg.BY_SUCCESS("查询角色成功",roleByList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.BY_NULL("暂无数据");
    }

    @GetMapping("/getSysRoleById/{id}")
    public ResultMsg getSysRoleById(@PathVariable Integer id){
        try {
            if(id==null) return ResultMsg.BY_ERROR("ID为空");
            SysRole role = sysRoleService.getRoleById(id);
            if(role!=null)return ResultMsg.BY_SUCCESS("成功获取数据",role);

        }catch (Exception e){
            e.printStackTrace();
        }

        return ResultMsg.BY_NULL("没有查找到或结果为空");
    }

    @PostMapping("/updateSysRole")
    public ResultMsg updateSysRole(SysRole sysRole){
        try {
            if(sysRole== null) return ResultMsg.BY_NULL("数据为空");
           boolean ax = sysRoleService.updateRoles(sysRole);
           return ResultMsg.BY_SUCCESS("修改成功",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ResultMsg.BY_ERROR("修改失败");
    }

    @GetMapping("/deleteSysRole/{id}")
    public ResultMsg deleteSysRole(@PathVariable Integer id){
        if(id == null) return ResultMsg.BY_NULL("ID为空");
        try {
            sysRoleService.removeRoles(id);
            return ResultMsg.BY_SUCCESS("删除成功",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.BY_NULL("删除失败或者没有此ID");
    }




}
