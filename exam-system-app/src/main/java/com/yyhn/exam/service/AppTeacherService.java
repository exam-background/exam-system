package com.yyhn.exam.service;

import com.yyhn.exam.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import javax.servlet.http.HttpServletRequest;

public interface AppTeacherService {
    public String banLogin(String loginName, String loginPassword, HttpServletRequest request);

    public String jiaoLogin(String loginName, String loginPassword, HttpServletRequest request);

    String getEmailById(int id);

    String getEmailByLoginName(String loginName);

    int updatePasswordByName(String loginName,@Param("loginPassword")String loginPassword);

    Teacher getTeacherById( int id);

    boolean updatePassword(int id  , String newPassword);
}
