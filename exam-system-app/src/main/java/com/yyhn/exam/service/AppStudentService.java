package com.yyhn.exam.service;

import com.yyhn.exam.vo.StudentUserVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import javax.servlet.http.HttpServletRequest;

public interface AppStudentService {
    String doLogin(String loginName, String loginPassword, HttpServletRequest request);

    boolean updatePassword(int id , String oldPassword , String newPassword);

    String getEmailByLoginName(String loginName);

    int updatePasswordByName(String loginName, String loginPassword);

    StudentUserVo getStuById(int id);
}
