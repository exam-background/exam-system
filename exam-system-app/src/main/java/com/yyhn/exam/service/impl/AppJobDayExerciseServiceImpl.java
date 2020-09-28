package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.JobDayExerciseSubmit;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.mapper.AppJobDayExerciseMapper;
import com.yyhn.exam.service.AppJobDayExerciseService;
import com.yyhn.exam.service.AppJobDayExerciseSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppJobDayExerciseServiceImpl implements AppJobDayExerciseService {
    @Resource
    private AppJobDayExerciseMapper appJobDayExerciseMapper;
    @Resource
    private AppJobDayExerciseSubmitService appJobDayExerciseSubmitService;

    @Override
    public void getJobDayExerciseByProfessid(Integer id, Page<List<JobDayExercise>> page, Integer studentid) {
        List<JobDayExercise> lists = appJobDayExerciseMapper.getJobDayExerciseByProfessid(id, (page.getCurPage()-1)*page.getPageSize(), page.getPageSize());
        // 将做过的题排除在外
        List<JobDayExercise> list = new ArrayList<JobDayExercise>();
        // 查询做过的题目
        List<JobDayExerciseSubmit> jobDayExerciseSubmitList = appJobDayExerciseSubmitService.getJobDayExerciseSubmit(studentid);
        for(JobDayExercise jobDayExercise : lists){
            int a = 0;
            for(JobDayExerciseSubmit jobDayExerciseSubmit:jobDayExerciseSubmitList){
                if(jobDayExercise.getId() == jobDayExerciseSubmit.getExerciseId()){
                    a = 1;
                    break;
                } 
            }
            if(a == 0){
                list.add(jobDayExercise);
            }
        }
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
