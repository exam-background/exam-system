package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.mapper.JobDayExerciseMapper;
import com.yyhn.exam.service.JobDayExerciseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        if (page != null){
            map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
            map.put("pageSize",page.getPageSize());
        }

        List<JobDayExercise> jobDayExerciseList = jobDayExerciseMapper.getAllJobDayExercise(map);
        int total = jobDayExerciseMapper.getCount(map);

        page.setData(jobDayExerciseList);
        page.setTotal(total);
    }

    @Override
    public List<JobDayExercise> getAllJobDayExercise(String title, Integer professionalId, Integer courseId) {
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("professionalId",professionalId);
        map.put("courseId",courseId);

        return jobDayExerciseMapper.getAllJobDayExercise(map);
    }

    @Override
    public int deletesJobDayExercise(List<JobDayExercise> list) {
        List<Integer> lists = new ArrayList<Integer>();
        for(JobDayExercise jobDayExercise : list){
            lists.add(jobDayExercise.getId());
        }
        return jobDayExerciseMapper.deletesJobDayExercise(lists);
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
    public JobDayExercise getJobDayExerciseById(Integer id) {
        JobDayExercise jobDayExercise = jobDayExerciseMapper.getJobDayExerciseById(id);
        return  jobDayExercise;
    }

    @Override
    public List<JobDayExercise> getJobDayExerciseByProfessionalId(Integer professionalId) {
        if(professionalId != 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("Professional_id", professionalId);
            return jobDayExerciseMapper.getAllJobDayExercise(map);
        }else{
            return jobDayExerciseMapper.getAllJobDayExercise(null);
        }
    }

    @Override
    public int getJobDayExerciseByCourse(Integer professionalId, Integer courseId) {
        return jobDayExerciseMapper.getJobDayExerciseByCourse(professionalId, courseId);
    }

    @Override
    public JobDayExercise getJobDayExerciseBypProfessionalCourse(Integer professionalId, Integer courseId, Integer page) {
        return jobDayExerciseMapper.getJobDayExerciseBypProfessionalCourse(professionalId, courseId, page);
    }
}
