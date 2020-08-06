package com.yyhn.exam.service;

import com.yyhn.exam.entity.Papers;

import java.util.List;

public interface PapersService {
    /**
     * 条件查询试卷
     * @param papers
     * @return
     */
    public List<Papers> getPapersAll(Papers papers);

    /**
     * 根据id删除试卷
     * @param id
     * @return
     */
    public void deletePapers(Integer id) throws RuntimeException;

    /**
     * 添加试卷
     * @param papers
     * @return
     */
    public void insertPapers(Papers papers) throws RuntimeException;

    /**
     * 发布试卷
     * @param id
     * @return
     */
    public int publishPapers(Integer id);
}
