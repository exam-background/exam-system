package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.JobDayExerciseSubmit;
import com.yyhn.exam.mapper.JobDayExerciseSubmitMapper;
import com.yyhn.exam.service.JobDayExerciseSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class JobDayExerciseSubmitServiceImpl implements JobDayExerciseSubmitService {
    @Resource
    private JobDayExerciseSubmitMapper jobDayExerciseSubmitMapper;

    @Override
    public int addJobDayExerciseSubmit(JobDayExerciseSubmit jobDayExerciseSubmit) {
        return jobDayExerciseSubmitMapper.insert(jobDayExerciseSubmit);
    }
}
