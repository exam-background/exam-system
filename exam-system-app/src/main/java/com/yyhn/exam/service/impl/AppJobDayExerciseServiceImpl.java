package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.mapper.AppJobDayExerciseMapper;
import com.yyhn.exam.mapper.JobDayExerciseMapper;
import com.yyhn.exam.service.AppJobDayExerciseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppJobDayExerciseServiceImpl implements AppJobDayExerciseService {
    @Resource
    private AppJobDayExerciseMapper appJobDayExerciseMapper;

    @Override
    public List<JobDayExercise> getJobDayExerciseByProfessid(Integer id) {
        return appJobDayExerciseMapper.getJobDayExerciseByProfessid(id);
    }
}
