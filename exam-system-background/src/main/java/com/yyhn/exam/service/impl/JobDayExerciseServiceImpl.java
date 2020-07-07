package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.mapper.JobDayExerciseMapper;
import com.yyhn.exam.service.JobDayExerciseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JobDayExerciseServiceImpl implements JobDayExerciseService {

    @Resource
    JobDayExerciseMapper jobDayExerciseMapper;

    @Override
    public void getAllJobDayExercise(String title, Integer professionalId, Integer courseId, Page<List<JobDayExercise>> page) {
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("professionalId",professionalId);
        map.put("courseId",courseId);
        map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());

        List<JobDayExercise> jobDayExerciseList = jobDayExerciseMapper.getAllJobDayExercise(map);
        int total = jobDayExerciseMapper.getCount(map);

        page.setData(jobDayExerciseList);
        page.setTotal(total);
    }

    @Override
    public int addJobDayExercise(JobDayExercise jobDayExercise) {
        int count = jobDayExerciseMapper.addJobDayExercise(jobDayExercise);
        return count;
    }

    @Override
    public int updateJobDayExercise(JobDayExercise jobDayExercise) {
        int count = jobDayExerciseMapper.updateJobDayExercise(jobDayExercise);
        return count;
    }

    @Override
    public int deleteJobDayExercise(int id) {
        int count = jobDayExerciseMapper.deleteJobDayExercise(id);
        return count;
    }

    @Override
    public JobDayExercise getJobDayExerciseById(int id) {
        JobDayExercise jobDayExercise = jobDayExerciseMapper.getJobDayExerciseById(id);
        return  jobDayExercise;
    }
}
