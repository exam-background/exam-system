package com.yyhn.exam.service;

import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;

import java.util.List;

public interface AppTechnologyDayExerciseService {
    public List<TechnologyDayExercise> getTechnologyDayExerciseSubmit(Integer id);
}
