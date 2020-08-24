package com.yyhn.exam.service.impl;

import com.yyhn.exam.service.TechnologyDayExerciseSubmitService;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.mapper.TechnologyDayExerciseSubmitMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TechnologyDayExerciseSubmitServiceImpl implements TechnologyDayExerciseSubmitService {
    @Resource
    private TechnologyDayExerciseSubmitMapper technologyDayExerciseSubmitMapper;

    @Override
    public int addTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit) {
        return (technologyDayExerciseSubmitMapper.insert(technologyDayExerciseSubmit));
    }

    @Override
    public int getTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit) {
        return 0;
    }
}
