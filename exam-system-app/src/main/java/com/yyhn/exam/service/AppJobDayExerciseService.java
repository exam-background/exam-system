package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;

import java.util.List;

public interface AppJobDayExerciseService {
    /**
     * 根据科目id查询题目信息
     * @param id
     * @return
     */
    public void getJobDayExerciseByProfessid(Integer id, Page<List<JobDayExercise>> page);

    /**
     * 根据id查询题目信息
     * @param id
     * @return
     */
    public JobDayExercise getJobDayExerciseById(Integer id);
}
