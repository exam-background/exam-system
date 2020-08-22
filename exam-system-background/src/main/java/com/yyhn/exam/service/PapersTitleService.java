package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.entity.PapersUser;

import java.util.List;

public interface PapersTitleService {
    /**
     * 根据试卷id删除考试题目
     * @param id
     * @return
     */
    void deletePapersTitle(Integer id) throws RuntimeException;

    /**
     * 添加考试用户
     * @param papersTitle
     * @return
     */
    void insertPapersTitle(PapersTitle papersTitle) throws RuntimeException;

    /**
     * 根据试卷id获取题目id
     * @param id
     * @return
     */
    List<PapersTitle> getPapersTitleByPapersId(Integer id);

    /**
     * 修改题目分数
     * @param papersTitle
     * @return
     */
    void updatePapersTitleByScore(PapersTitle papersTitle) throws RuntimeException;
}
