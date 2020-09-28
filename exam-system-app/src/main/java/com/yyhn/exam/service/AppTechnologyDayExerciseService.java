package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.TechnologyDayExercise;

import java.util.List;

public interface AppTechnologyDayExerciseService {
    public void getTechnologyDayExerciseSubmit(Integer id, Page<List<TechnologyDayExercise>> page, Integer studentid);

    /**
     * 根据题目id查询题目
     * @param id
     * @return
     */
    TechnologyDayExercise getTechnologyDayExerciseById(Integer id);
}
