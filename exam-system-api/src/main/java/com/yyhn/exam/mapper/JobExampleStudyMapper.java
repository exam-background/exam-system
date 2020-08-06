package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.JobExampleStudy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JobExampleStudyMapper {

    /**
     * 根据条件获取就业示范学习信息
     * @return
     */
    public List<JobExampleStudy> getAllJobExampleStudy(Map<String,Object> map);

    /**
     * 获取总记录数
     * @return
     */
    public int getCount(Map<String,Object> map);


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
