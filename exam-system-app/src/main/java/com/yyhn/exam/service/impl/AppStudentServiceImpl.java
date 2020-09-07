package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.Student;
import com.yyhn.exam.mapper.StudentMapper;
import com.yyhn.exam.service.AppStudentService;
import com.yyhn.exam.service.StudentTokenService;
import com.yyhn.exam.vo.StudentUserVo;
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
    @Override
    public boolean updatePassword(int id, String oldPassword, String newPassword) {
        String loginPassword = studentMapper.getLoginPassword(id);
        if(null != loginPassword && !"".equals(loginPassword)){
            System.out.println(loginPassword+oldPassword + "---"+passwordEncoder.matches(oldPassword,loginPassword));
            if(passwordEncoder.matches(oldPassword,loginPassword)){
                if(studentMapper.updatePassword(id, passwordEncoder.encode(newPassword))>0){
                    return true;
                }
                return false;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    @Override
    public String getEmailByLoginName(String loginName) {
        return studentMapper.getEmailByLoginName(loginName);
    }

    @Override
    public int updatePasswordByName(String loginName, String loginPassword) {
        return studentMapper.updatePasswordByName(loginName,passwordEncoder.encode(loginPassword));
    }

    @Override
    public StudentUserVo getStuById(int id) {
        return studentMapper.getStuById(id);
    }
}
