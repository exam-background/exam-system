package com.yyhn.exam.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app/Student")
@Api("app端登录接口")
public class AppLoginController {
    @ApiOperation(value = "测试")
    @GetMapping("/teststest")
    public String test(){
        return "test";
    }
}
