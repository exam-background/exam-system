package com.yyhn.exam.security;

import com.alibaba.fastjson.JSON;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
public class ResultFulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
       httpServletResponse.setCharacterEncoding("UTF-8");
       httpServletResponse.setContentType("application/json");
       httpServletResponse.getWriter().println(JSON.toJSON(e.getMessage()));
       httpServletResponse.getWriter().flush();
    }
}
