package com.yyhn.exam.controller;

import com.yyhn.exam.common.TokenService;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.service.AppStudentService;
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

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
