package com.yyhn.exam.service;

public interface PapersUserResultService {
    /**
     * 根据试卷id删除考试表内容
     * @param id
     */
    public void deletePapersUserResult(Integer id) throws RuntimeException;
}
