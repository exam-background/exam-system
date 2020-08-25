package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersUserResult;

import java.util.List;

public interface AppPapersUserResultService {
    /**
     * 根据试卷id和学生id查询错题
     * @param papersId
     * @param userid
     * @return
     */
    public List<PapersUserResult> getPapersUserResultByRight(Integer papersId, Integer userid);

    /**
     * 添加学生作答
     * @param papersUserResult
     * @return
     */
    public int insertPapersUserResult(PapersUserResult papersUserResult);

    /**
     * 根据题目信息修改考生题目信息
     * @param papersUserResult
     * @return
     */
    public int updatePapersUserResult(PapersUserResult papersUserResult);
}
