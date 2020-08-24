package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersUser;

import java.util.List;

public interface PapersUserService {
    /**
     * 根据学生id查询所有考试试卷
     * @param id
     * @return
     */
    List<PapersUser> getPapersUserByUserId(Integer id);
}
