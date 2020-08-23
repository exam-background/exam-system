package com.yyhn.exam.service;

import com.yyhn.exam.entity.JobDayExercise;

import java.util.List;

public interface AppJobDayExerciseService {
    /**
     * 根据科目id查询题目信息
     * @param id
     * @return
     */
    public List<JobDayExercise> getJobDayExerciseByProfessid(Integer id);
}
