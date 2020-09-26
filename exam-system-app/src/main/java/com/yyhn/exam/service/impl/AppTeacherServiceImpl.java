package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.TeacherTokenService;
import com.yyhn.exam.entity.Teacher;
import com.yyhn.exam.mapper.TeacherMapper;
import com.yyhn.exam.service.AppTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Service
public class AppTeacherServiceImpl implements AppTeacherService {
    @Resource
    private TeacherMapper teacherMapper;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TeacherTokenService tokenService;
    @Override
    public String banLogin(String loginName, String loginPassword, HttpServletRequest request) {
        Teacher teacher = teacherMapper.banLogin(loginName);
  //      System.out.println(teacher.toString()+"--------------");
        return getString(loginPassword, request, teacher);
    }

    private String getString(String loginPassword, HttpServletRequest request, Teacher teacher) {
        if(null != teacher){
            if(null != teacher.getLoginPassword() && !"".equals(teacher.getLoginPassword())){
                System.out.println("数据库中的"+teacher.getLoginPassword()+"----输入的"+loginPassword+"加密后的"+passwordEncoder.matches(loginPassword,teacher.getLoginPassword()));
                if(passwordEncoder.matches(loginPassword,teacher.getLoginPassword())){
                    String token = tokenService.generateToken(request.getHeader("user-agent"),teacher);
                    tokenService.save(token,teacher);
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

    @Override
    public String jiaoLogin(String loginName, String loginPassword, HttpServletRequest request) {
        Teacher teacher = teacherMapper.jiaoLogin(loginName);
        return getString(loginPassword, request, teacher);
    }

    @Override
    public String getEmailById(int id) {
        return teacherMapper.getEmailById(id);
    }

    @Override
    public String getEmailByLoginName(String loginName) {
        return teacherMapper.getEmailByLoginName(loginName);
    }

    @Override
    public int updatePasswordByName(String loginName, String loginPassword) {
        return teacherMapper.updatePasswordByName(loginName,loginPassword);
    }

    @Override
    public Teacher getTeacherById(int id) {
        return teacherMapper.getTeacherById(id);
    }

    @Override
    public boolean updatePassword(int id, String newPassword) {
        //String loginPassword = teacherMapper.
        if(null != newPassword && !"".equals(newPassword)){
            // System.out.println(loginPassword+oldPassword + "---"+passwordEncoder.matches(oldPassword,loginPassword));
            if(teacherMapper.updatePassword(id, passwordEncoder.encode(newPassword))>0){
                return true;
            }
            return false;
        }else{
            return false;
        }
    }
}
