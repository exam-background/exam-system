package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;

import java.util.List;

public interface AppTechnologyDayExerciseService {
    public void getTechnologyDayExerciseSubmit(Integer id, Page<List<TechnologyDayExercise>> page);
}
