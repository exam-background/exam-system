package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.JobDayExerciseSubmit;
import com.yyhn.exam.mapper.JobDayExerciseSubmitMapper;
import com.yyhn.exam.service.AppJobDayExerciseSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppJobDayExerciseSubmitServiceImpl implements AppJobDayExerciseSubmitService {
    @Resource
    private JobDayExerciseSubmitMapper jobDayExerciseSubmitMapper;

    @Override
    public List<JobDayExerciseSubmit> getJobDayExerciseSubmitByUserId(Integer id) {
        return jobDayExerciseSubmitMapper.getJobDayExerciseSubmitByUserId(id);
    }

    @Override
    public int addJobDayExerciseSubmit(JobDayExerciseSubmit jobDayExerciseSubmit) {
        return jobDayExerciseSubmitMapper.insert(jobDayExerciseSubmit);
    }

    @Override
    public List<JobDayExerciseSubmit> getJobDayExerciseSubmitByRight(Integer id) {
        return jobDayExerciseSubmitMapper.getJobDayExerciseSubmitByRight(id);
    }
}
