package com.yyhn.exam.service;

import com.yyhn.exam.entity.Papers;
import com.yyhn.exam.entity.PapersCourse;

public interface PapersCourseService {
    /**
     * 根据试卷id删除试卷科目关系
     * @param id
     * @return
     */
    int deletePapersCourse(Integer id) throws RuntimeException;

    /**
     * 添加试卷科目关系
     * @param papersCourse
     * @return
     */
    void insertPapersCourse(PapersCourse papersCourse) throws RuntimeException;
}
