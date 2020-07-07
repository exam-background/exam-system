package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.entity.Professional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


public interface JobExampleStudyService {
    /**
     * 根据条件获取就业示范学习信息
     * @return
     */
    public void getAllJobExampleStudy(String title,Integer profesionalId,Integer courseId, Page<List<JobExampleStudy>> page);

    /**
     * 增加就业示范学习信息
     * @return
     */
    public int addJobExampleStudy(JobExampleStudy jobExampleStudy);


    /**
     * 修改就业示范学习信息
     * @return
     */
    public int updateJobExampleStudy(JobExampleStudy jobExampleStudy);


    /**
     * 删除就业示范学习信息
     * @return
     */
    public int deleteJobExampleStudy(int id);

    /**
     * 根据ID 获取就业示范学习信息
     * @param id
     * @return
     */
    public JobExampleStudy getJobExampleStudyById(int id);
}
