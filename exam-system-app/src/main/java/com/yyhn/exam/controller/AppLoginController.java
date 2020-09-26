package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.service.AppStudentService;
import com.yyhn.exam.service.MailService;
import com.yyhn.exam.service.AppTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/app/Student")
@Api("app端登录接口")
public class AppLoginController {
    @Autowired
    private AppStudentService appStudentService;
    @Autowired
    private MailService mailService;
    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private AppTeacherService teacherService;
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

    @ApiOperation(value = "班主任登录·")
    @PostMapping("/banLogin")
    public ResultMsg banLogin(String loginName, String loginPassword, HttpServletRequest request){
        System.out.println(loginName+loginPassword+"loginController-banLogin()");
        //String token = teacherService.banLogin(loginName,loginPassword,request);
        String token = teacherService.banLogin(loginName,loginPassword,request);
        if(null != token && !"".equals(token)){
            System.out.println("token是"+token);
            return ResultMsg.BY_SUCCESS("成功",token);
        }else{
            return ResultMsg.BY_FAIL("失败");
        }
    }

    @ApiOperation(value = "教员登录·")
    @PostMapping("/jiaoLogin")
    public ResultMsg jiaoLogin(String loginName, String loginPassword, HttpServletRequest request){
        System.out.println(loginName+loginPassword+"loginController-banLogin()");
        //String token = teacherService.banLogin(loginName,loginPassword,request);
        String token = teacherService.jiaoLogin(loginName,loginPassword,request);
        if(null != token && !"".equals(token)){
            System.out.println("token是"+token);
            return ResultMsg.BY_SUCCESS("成功",token);
        }else{
            return ResultMsg.BY_FAIL("失败");
        }
    }

    @ApiOperation("修改密码")
    @PostMapping("/updatePassord")
    public ResultMsg updatePassword_2(int id,String newPassword){
        if(appStudentService.updatePassword(id,newPassword)){
            return ResultMsg.BY_SUCCESS("修改成功","");
        }else{
            return ResultMsg.BY_FAIL("修改失败，请检查密码");
        }
    }

    @ApiOperation("验证邮箱验证码")
    @PostMapping("/checkMail")
    public ResultMsg updatePassword(int id, String code) {
        if(redisTemplate.hasKey("email_check_"+id)){
            ValueOperations valueOperations = redisTemplate.opsForValue();
            String yzm = (String) valueOperations.get("email_check_"+id);
            if(code.equals(yzm)){
                return ResultMsg.BY_SUCCESS("验证成功","");
            }else{
                return ResultMsg.BY_ERROR("验证失败");
            }
        }else{
            return ResultMsg.BY_NULL("验证过期，请重试");
        }
    }

    @ApiOperation("/找回密码-发送邮件")
    @PostMapping("/backPassword")
    public ResultMsg backPassword(@RequestParam("id") int id){
        String email = appStudentService.getEmailById(id);
        System.out.println(email);
        if(null != email && !"".equals(email)){
            Long random = Math.round((Math.random()+1) * 1000);
            mailService.sendMail("2857135639@qq.com", email, "", "找回密码", "您的验证码是" + random + ",请妥善保管");
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set("email_check_"+id,random.toString(),2, TimeUnit.MINUTES);
            return ResultMsg.BY_SUCCESS("邮件发送成功","");
        }else{
            return ResultMsg.BY_NULL("该学生没有设置安全邮箱");
        }
    }


    //老师更改密码

    @ApiOperation("修改密码")
    @PostMapping("/teacherUpdatePassord")
    public ResultMsg updatePassword_4(int id,String newPassword){
        if(teacherService.updatePassword(id,newPassword)){
            return ResultMsg.BY_SUCCESS("修改成功","");
        }else{
            return ResultMsg.BY_FAIL("修改失败，请检查密码");
        }
    }

    @ApiOperation("验证邮箱验证码")
    @PostMapping("/teacherCheckMail")
    public ResultMsg updatePassword_3(int id, String code) {
    System.out.println(id+"ididididid "+code);
        if(redisTemplate.hasKey("teacher_email_check_"+id)){
            ValueOperations valueOperations = redisTemplate.opsForValue();
            String yzm = (String) valueOperations.get("teacher_email_check_"+id);
            if(code.equals(yzm)){
                return ResultMsg.BY_SUCCESS("验证成功","");
            }else{
                return ResultMsg.BY_ERROR("验证失败");
            }
        }else{
            return ResultMsg.BY_NULL("验证过期，请重试");
        }
    }

    @ApiOperation("/找回密码-发送邮件")
    @PostMapping("/teacherBackPassword")
    public ResultMsg backPassword_2(@RequestParam("id") int id){
        String email = teacherService.getEmailById(id);
        System.out.println(email);
        if(null != email && !"".equals(email)){
            Long random = Math.round((Math.random()+1) * 1000);
            mailService.sendMail("2857135639@qq.com", email, "", "找回密码", "您的验证码是" + random + ",请妥善保管");
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set("teacher_email_check_"+id,random.toString(),2, TimeUnit.MINUTES);
            return ResultMsg.BY_SUCCESS("邮件发送成功","");
        }else{
            return ResultMsg.BY_NULL("该学生没有设置安全邮箱");
        }
    }
}
