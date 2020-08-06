package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersCourse;
import com.yyhn.exam.entity.PapersUser;

public interface PapersUserService {
    /**
     * 根据试卷id删除考试用户
     * @param id
     * @return
     */
    void deletePapersUser(Integer id) throws RuntimeException;

    /**
     * 添加考试用户
     * @param papersUser
     * @return
     */
    void insertPapersUser(PapersUser papersUser) throws RuntimeException;
}
