package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersUserResult;

import java.util.List;

public interface PapersUserResultService {
    /**
     * 根据试卷id删除考试表内容
     * @param id
     */
    public int deletePapersUserResult(Integer id) throws RuntimeException;

    /**
     * 根据id修改题目分值和正确
     * @param papersUserResult
     * @return
     */
    public int updatePapersUserResult(PapersUserResult papersUserResult);

    /**
     * 根据用户id查询做的题目
     * @param id
     * @return
     */
    public List<PapersUserResult> getPapersUserResultByUserId(Integer id, Integer papersId);
}
