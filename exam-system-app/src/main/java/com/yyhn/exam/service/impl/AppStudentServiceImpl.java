package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.Student;
import com.yyhn.exam.mapper.StudentMapper;
import com.yyhn.exam.service.AppStudentService;
import com.yyhn.exam.service.StudentTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class AppStudentServiceImpl implements AppStudentService {
    @Resource
   private StudentMapper studentMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Autowired
    private StudentTokenService tokenService;
    @Override
    public String doLogin(String loginName, String loginPassword, HttpServletRequest request) {
        Student student = studentMapper.doLogin(loginName);
        if(null != student){
            if(null != student.getLoginPassword() && !"".equals(student.getLoginPassword())){
                System.out.println("数据库中的"+student.getLoginPassword()+"----输入的"+loginPassword+"加密后的"+passwordEncoder.matches(loginPassword,student.getLoginPassword()));
                if(passwordEncoder.matches(loginPassword,student.getLoginPassword())){
                    String token = tokenService.generateToken(request.getHeader("user-agent"),student);
                    tokenService.save(token,student);
                    return token;
                }else{
                    return null;
                }
            }else{
                return null;
            }
        }else{
            return null;
        }
    }
}
