package com.yyhn.exam.service;

import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;

import java.util.List;

public interface AppTechnologyDayExerciseSubmitService {
    /**
     * 根据学生id查询技术训练每日一练
     * @param id
     * @return
     */
    List<TechnologyDayExerciseSubmit> getTechnologyDayExerciseSubmitByUserId(Integer id);

    /**
     * 添加学生做过的题目
     * @param technologyDayExerciseSubmit
     * @return
     */
    public int addTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit);

    /**
     * 根据学生id查询技术训练错题
     * @param id
     * @return
     */
    public List<TechnologyDayExerciseSubmit> getTechnologyDayExerciseSubmitByRight(Integer id);
}
