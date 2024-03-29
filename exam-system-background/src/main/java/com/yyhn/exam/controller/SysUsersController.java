package com.yyhn.exam.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.yyhn.exam.common.Dto;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.entity.UserHasRole;
import com.yyhn.exam.mapper.SysUserMapper;
import com.yyhn.exam.mapper.SysUserRoleMapper;
import com.yyhn.exam.service.SysRoleService;
import com.yyhn.exam.service.SysUserRoleService;
import com.yyhn.exam.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api( value = "针对用户信息进行维护",description = "用户管理控制器类")
public class SysUsersController {
    @Resource
    private SysUserService sysUserService;
    @Resource
    private PasswordEncoder pwd;
    @Resource
    private SysRoleService sysRoleService;
    @Resource
    private SysUserRoleService sysUserRoleService;

    @ApiOperation(value = "删除用户信息", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "删除用户信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/deleteSysUser", method = RequestMethod.POST)
    public Object deleteSysUser(int id){
        if(sysUserService.deleteSysUser(id) > 0){
            return ResultMsg.BY_SUCCESS("删除成功", null);
        }else{
            return ResultMsg.BY_FAIL("删除失败");
        }
    }

    @ApiOperation(value = "增加用户信息", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "增加用户信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/insertSysUser", method = RequestMethod.POST)
    public Object insertSysUser(SysUser sysUser){
        System.out.println(sysUser+"00000000000000"+sysUser.getPosition());


        sysUser.setLogin_password(pwd.encode(sysUser.getLogin_password()));
        if(sysUserService.addSysUser(sysUser) > 0){
            Integer userId = sysUserService.getUserIdByUserNameAndPassword(sysUser.getLoginName(),sysUser.getLogin_password());
            Integer roleId = sysRoleService.getRoleIdByMark(sysUser.getPosition());
            sysUserRoleService.insert(userId,roleId);
            return ResultMsg.BY_SUCCESS("增加成功", null);
        }else{
            return ResultMsg.BY_FAIL("增加失败");
        }
    }

    @ApiOperation(value = "查询用户信息", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有学生信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/getSysUserByPage",method = RequestMethod.POST)
    public Object getSysUserByPage(@RequestParam(required = false, defaultValue = "")String department,@RequestParam(required = false, defaultValue = "") String position, Integer page, Integer pageSize){
        List<SysUser> list = sysUserService.getSysUserByPage(department, position, page, pageSize);
        if(list != null && list.size()>0){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @ApiOperation(value = "修改用户信息", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "修改用户信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/updateSysUser",method = RequestMethod.POST)
    public Object updateSysUser(SysUser sysUser){
        if(sysUser.getLogin_password() != null && sysUser.getLogin_password() != ""){
            System.out.println("password:::::"+sysUser.getLogin_password());
            sysUser.setLogin_password(pwd.encode(sysUser.getLogin_password()));
        }
        if(sysUserService.updateSysUser(sysUser)>0){
          Integer roleId =  sysRoleService.getRoleIdByMark(sysUser.getPosition());
          Integer userId = sysUserService.getUserIdByUserNameOrPassword(sysUser.getLoginName(),sysUser.getLogin_password());
          sysRoleService.updateUserRole(userId,roleId);
            if(sysUser.getLogin_password() != null && sysUser.getLogin_password() != ""){
                System.out.println("用户密码更改");
            }
            return ResultMsg.BY_SUCCESS("修改成功", null);
        }else{
            return ResultMsg.BY_FAIL("修改失败");
        }
    }

    @ApiOperation(value = "批量删除用户信息", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "修X改用户信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/deleteSysUsers",method = RequestMethod.POST)
    public Object deleteSysUsers(List<SysUser> list){
        if(sysUserService.deleteSysUsers(list)>0){
            return ResultMsg.BY_SUCCESS("批量删除成功", null);
        }else{
            return ResultMsg.BY_FAIL("批量失败");
        }
    }
}
