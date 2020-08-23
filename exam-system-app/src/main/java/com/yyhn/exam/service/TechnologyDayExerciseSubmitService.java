package com.yyhn.exam.service;

import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;

public interface TechnologyDayExerciseSubmitService {
    /**
     * 添加题目
     * @param technologyDayExerciseSubmit
     * @return
     */
    public int addTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit);

    public int getTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit);
}
