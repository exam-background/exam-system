package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.JobDayExerciseSubmit;
import com.yyhn.exam.mapper.JobDayExerciseSubmitMapper;
import com.yyhn.exam.service.AppJobDayExerciseSubmitService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public List<JobDayExerciseSubmit> getJobDayExerciseSubmit(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("student_id", id);
        return jobDayExerciseSubmitMapper.selectByMap(map);
    }
}
