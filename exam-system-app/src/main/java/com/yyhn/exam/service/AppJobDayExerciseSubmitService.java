package com.yyhn.exam.service;

import com.yyhn.exam.entity.JobDayExerciseSubmit;

import java.util.List;

public interface AppJobDayExerciseSubmitService {
    /**
     * 根据学生id查询做过的就业每日一练
     * @param id
     * @return
     */
    List<JobDayExerciseSubmit> getJobDayExerciseSubmitByUserId(Integer id);

    /**
     * 添加学生做过的就业每日一练
     * @param jobDayExerciseSubmit
     * @return
     */
    public int addJobDayExerciseSubmit(JobDayExerciseSubmit jobDayExerciseSubmit);

    /**
     * 根据学生id查询错误的每日一练
     * @param id
     * @return
     */
    List<JobDayExerciseSubmit> getJobDayExerciseSubmitByRight(Integer id);
}
