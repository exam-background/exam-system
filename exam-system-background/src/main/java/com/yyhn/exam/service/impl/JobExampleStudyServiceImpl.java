package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.mapper.JobExampleStudyMapper;
import com.yyhn.exam.service.JobExampleStudyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class JobExampleStudyServiceImpl implements JobExampleStudyService {
    @Resource
    JobExampleStudyMapper jobExampleStudyMapper;

    @Override
    public void getAllJobExampleStudy(String title, Integer professionalId, Integer courseId, Page<List<JobExampleStudy>> page) {
        Map<String,Object> map = new HashMap<>();
        map.put("title",title);
        map.put("professionalId",professionalId);
        map.put("courseId",courseId);
        map.put("startRow",page.getCurPage()*page.getPageSize());
        map.put("pageSize",page.getPageSize());

        List<JobExampleStudy> exampleStudyList = jobExampleStudyMapper.getAllJobExampleStudy(map);
        int total = jobExampleStudyMapper.getCount(map);
        page.setData(exampleStudyList);
        page.setTotal(total);
    }



    @Override
    public int addJobExampleStudy(JobExampleStudy jobExampleStudy) {
        return jobExampleStudyMapper.addJobExampleStudy(jobExampleStudy);
    }

    @Override
    public int updateJobExampleStudy(JobExampleStudy jobExampleStudy) {
        return  jobExampleStudyMapper.updateJobExampleStudy(jobExampleStudy);

    }

    @Override
    public int deleteJobExampleStudy(int id) {
         return jobExampleStudyMapper.deleteJobExampleStudy(id);

    }
    public JobExampleStudy getJobExampleStudyById(int id){
        return jobExampleStudyMapper.getJobExampleStudyById(id);
    }
}
