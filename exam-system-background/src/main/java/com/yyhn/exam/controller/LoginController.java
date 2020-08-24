package com.yyhn.exam.controller;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.yyhn.exam.common.*;
import com.yyhn.exam.entity.SysMenu;
import com.yyhn.exam.service.SysMenuService;
import com.yyhn.exam.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Api(value = "登录控制器", description = "登录")
@RestController
public class LoginController {
    Logger log = Logger.getLogger(LoginController.class);

    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @Autowired
    SysMenuService sysMenuService;
    private static final String SESSION_KEY = "KAPTCHA_SESSION_KEY";
    @Autowired
    SysUserService sysUserService;

    @Autowired
    TokenService tokenService;
    @ApiOperation(value = "获取后台测试连接", httpMethod = "GET")
    @GetMapping("/getPower")
    public Object getPower(){
        return "true";
    }

    /**
     * 验证用户token 是否有效
     * @param userToken
     * @param request
     * @return
     */
    private boolean userValidate(String userToken, HttpServletRequest request) {
        if (tokenService.validate(request.getHeader("user-agent"), userToken)) {
            return true;
        } else {
            return false;
        }
    }

    @ApiOperation(value = "查询用户当前可操作的菜单", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "查询用户当前可操作的菜单" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>4002 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>")
    @PostMapping("/userMenu/{userToken}")
    public Object getUserMenu(@ApiParam("用户token") @PathVariable("userToken") String userToken, HttpServletRequest request) {
        //  log.info("-------------------------------我是"+userToken);

        if (userValidate(userToken, request)) {
            log.info("=======================正常");
            int userId = Integer.valueOf(userToken.split("-")[2]);
            List<SysMenu> menus = sysMenuService.selectMenuList(userId);
            return DtoUtil.returnDataSuccess(menus);
        } else {
            // log.info("=======================过期");
            return DtoUtil.returnFail("过期", "4002");
        }
    }

    @ApiOperation(value = "查询用户当前登录状态", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "查询用户当前登录状态" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>4002 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>")
    @PostMapping("/getUsersState")
    public Dto getUserState(String userToken, HttpServletRequest request) {
        if (userValidate(userToken, request)) {
            // log.info("=======================正常");
            stringRedisTemplate.opsForValue().set("online:" + tokenService.load(userToken), userToken, 60 * 2, TimeUnit.SECONDS);
            return DtoUtil.returnSuccess("正常" + tokenService.load(userToken));
        } else {
            // log.info("=======================过期");
            return DtoUtil.returnFail("过期", "4002");
        }
    }

    @ApiOperation(value = "验证码图形码输入是否正确", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "验证码图形码输入是否正确" +
            "<p> 传入 uuid  和 code(用户输入的验证码)成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>4001 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>")
    @PostMapping(value = "/checkCaptCha")
    public Dto checkCaptcha(String code, String uuid) {
        String rcode = stringRedisTemplate.opsForValue().get(uuid);
        log.error("----------有人来验证了--" + "  验证码：" + code + "-- 唯一编码" + uuid + " 系统生成验证码" + rcode);
        if (null != code && null != code) {
            if (code.equals(rcode)) {
                stringRedisTemplate.delete(uuid);
                return DtoUtil.returnSuccess("true");
            } else {
                return DtoUtil.returnFail("验证码错误请重试~", "4001");
            }
        }
        return null;
    }

    @ApiOperation(value = "登录方法", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "登录" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>4001 : 登录失败 账号或密码错误 </p>" +
            "<p>0 : 登录成功  后返回token 吧token存入LocalStroe 或者SessionStore</p>")
    @PostMapping(value = "/login")
    public Dto login(String username, String password, HttpServletRequest request) {

        String token = sysUserService.login(username, password, request);
        if (token == null) {
            return DtoUtil.returnFail("用户名或密码错误", "4001");
        }
        Map<String, String> tokenMap = new HashMap<>();
        tokenMap.put("token", token);
        return DtoUtil.returnDataSuccess(tokenMap);
    }

    @ApiOperation(value = "获取验证码 直接返回图片", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询用户当前可操作的菜单" +
            "<p>需要传入 uuid 可通过插件生成也可以传入当前时间戳 验证码时限五分钟：</p>")
    @GetMapping("/captcha")
    public void captchaValue(@RequestParam("uuid") String uuuid, HttpServletRequest request, HttpServletResponse response) throws IOException {
        log.error("------------!!!" + uuuid);
        byte[] captchaChallengeAsJpeg = null;
        ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
        try {
            String captcha = defaultKaptcha.createText();

            //存储

            //request.getSession().setAttribute("uuid", uuid);
            BufferedImage challenge = defaultKaptcha.createImage(captcha);
            ImageIO.write(challenge, "jpg", jpegOutputStream);
            log.info("图形验证码为：" + captcha + "---- uuid：" + uuuid);
            stringRedisTemplate.opsForValue().set(uuuid, captcha, 60 * 5, TimeUnit.SECONDS);
        } catch (IllegalArgumentException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
        response.setHeader("Cache-Control", "no-store");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = response.getOutputStream();
        outputStream.write(captchaChallengeAsJpeg);
        // outputStream.print("uuid==="+uuid);
        outputStream.flush();
        outputStream.close();
    }
}
