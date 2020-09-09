package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
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
    public void getJobDayExerciseByProfessid(Integer id, Page<List<JobDayExercise>> page) {
        List<JobDayExercise> list = appJobDayExerciseMapper.getJobDayExerciseByProfessid(id, (page.getCurPage()-1)*page.getPageSize(), page.getPageSize());
        int total = appJobDayExerciseMapper.getJobDayExerciseByCount(id);
        page.setData(list);
        page.setTotal(total);
        System.out.println(page);
    }

    @Override
    public JobDayExercise getJobDayExerciseById(Integer id) {
        return appJobDayExerciseMapper.selectById(id);
    }
}
