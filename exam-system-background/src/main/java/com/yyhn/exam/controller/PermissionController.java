package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.SysPermission;
import com.yyhn.exam.service.SysPermissionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "PermissionController",description = "用户权限操作")
public class PermissionController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @RequestMapping(value = "/getSysPermission",method = {RequestMethod.GET,RequestMethod.POST})
    public ResultMsg getSysPermission(String permissionName){
        List<SysPermission> permissionByList =null;
//        System.out.println("permissionName = " + permissionName);
        try{
            permissionByList = sysPermissionService.getPermissionByList(permissionName);
            return ResultMsg.BY_SUCCESS("获取数据成功",permissionByList);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  ResultMsg.BY_FAIL("获取权限数据失败");
    }

    @GetMapping("/deleteSysPermission/{id}")
    public ResultMsg deleteSysPermission(@PathVariable Integer id){
        if(id== null) return ResultMsg.BY_NULL("ID为空");
        try {
            sysPermissionService.removePermission(id);
            return ResultMsg.BY_SUCCESS("已成功删除",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.BY_FAIL("删除失败");
    }

    @PostMapping("/updateSysPermission")
    public ResultMsg updateSysPermission(SysPermission sysPermission){
        if(sysPermission== null) return ResultMsg.BY_NULL("修改对象为空");
        try {
            sysPermissionService.updatePermission(sysPermission);
            return ResultMsg.BY_SUCCESS("已成功修改",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.BY_FAIL("修改失败");
    }


    @GetMapping("/getSysPermissionById/{id}")
    public ResultMsg getSysPermissionById(@PathVariable Integer id){
        if(id== null) return ResultMsg.BY_NULL("ID为空");
        try {
            SysPermission permissionById = sysPermissionService.getPermissionById(id);
            return ResultMsg.BY_SUCCESS("已成功删除",permissionById);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.BY_FAIL("查找失败");
    }

    @PostMapping("/addPermission")
    public  ResultMsg addPermission(String permissionName){
        if(permissionName== null)return  ResultMsg.BY_NULL("权限名称为空");
        try{
            SysPermission sysPermission=new SysPermission();
            sysPermission.setPermissionName(permissionName);
            sysPermissionService.addPermission(sysPermission);
            return ResultMsg.BY_SUCCESS("添加权限成功",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultMsg.BY_ERROR("出现错误，添加权限失败");
    }


    @GetMapping("/getPermissionLevel1")
    public ResultMsg getPermissionLevel1(){


        return ResultMsg.BY_ERROR("系统错误");
    }


}
