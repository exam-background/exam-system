package com.yyhn.exam.controller;

import com.yyhn.exam.common.TokenService;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.mapper.StudentMapper;
import com.yyhn.exam.service.AppStudentService;
import com.yyhn.exam.service.MailService;
import com.yyhn.exam.service.StudentTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/app/Student")
@Api("app端登录接口")
public class AppLoginController {
    @Autowired
    private AppStudentService appStudentService;
    @Autowired
    private MailService mailService;
    @ApiOperation(value = "登录")
    @PostMapping("/doLogin")
    public ResultMsg doLogin(String loginName, String loginPassword, HttpServletRequest request){
        System.out.println(loginName+loginPassword+"loginController-doLogin()");
        String token = appStudentService.doLogin(loginName,loginPassword,request);
        if(null != token && !"".equals(token)){
            System.out.println("token是"+token);
            return ResultMsg.BY_SUCCESS("成功",token);
        }else{
            return ResultMsg.BY_FAIL("失败");
        }
    }
    @ApiOperation("修改密码")
    @PostMapping("/updatePassord")
    public ResultMsg updatePassword(int id , String oldPassword , String newPassword){
        if(appStudentService.updatePassword(id,oldPassword,newPassword)){
            return ResultMsg.BY_SUCCESS("修改成功","");
        }else{
            return ResultMsg.BY_FAIL("修改失败，请检查密码");
        }
    }

    @ApiOperation("/找回密码-发送邮件")
    @PostMapping("/backPassword")
    public ResultMsg backPassword(String loginName){
        String email = appStudentService.getEmailByLoginName(loginName);
        if(null != email && !"".equals(email)){
            Long random = Math.round((Math.random()+1) * 1000);
            mailService.sendMail("2857135639@qq.com", email, "3255252963@qq.com", "找回密码", "您的验证码是" + random + ",请妥善保管");
            return ResultMsg.BY_SUCCESS("邮件发送成功","");
        }else{
            return ResultMsg.BY_NULL("没有该学生");
        }
    }
    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
