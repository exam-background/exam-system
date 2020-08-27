package com.yyhn.exam.service;

import javax.servlet.http.HttpServletRequest;

public interface AppStudentService {
    String doLogin(String loginName, String loginPassword, HttpServletRequest request);
}
