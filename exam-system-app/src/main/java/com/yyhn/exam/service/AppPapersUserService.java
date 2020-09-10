package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersUser;

import java.util.List;

public interface AppPapersUserService {
    /**
     * 根据学生id查询所有考试试卷
     * @param id
     * @return
     */
    List<PapersUser> getPapersUserByUserId(Integer id);

    /**
     * 根据用户id和试卷id缺点是学生已经考试的试卷
     * @param userId
     * @param papersId
     * @return
     */
    int updateIsPapers(Integer userId, Integer papersId);
}
