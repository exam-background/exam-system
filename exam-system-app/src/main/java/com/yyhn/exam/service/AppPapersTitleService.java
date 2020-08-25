package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersTitle;

import java.util.List;

public interface AppPapersTitleService {
    /**
     * 根据学生作答的试卷id查询对应题目信息
     * @param id
     * @return
     */
    public List<PapersTitle> getPapersTitleByPapersid(Integer id);
}
