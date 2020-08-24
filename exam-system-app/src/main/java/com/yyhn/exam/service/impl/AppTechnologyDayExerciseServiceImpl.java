package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.mapper.AppTechnologyDayExerciseMapper;
import com.yyhn.exam.service.AppTechnologyDayExerciseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppTechnologyDayExerciseServiceImpl implements AppTechnologyDayExerciseService {
    @Resource
    private AppTechnologyDayExerciseMapper appTechnologyDayExerciseMapper;

    @Override
    public List<TechnologyDayExercise> getTechnologyDayExerciseSubmit(Integer id) {
        return appTechnologyDayExerciseMapper.getTechnologyDayExerciseSubmit(id);
    }
}
