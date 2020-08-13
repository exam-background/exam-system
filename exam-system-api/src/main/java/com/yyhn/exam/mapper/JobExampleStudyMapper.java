package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.JobExampleStudy;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 获取题库中该科目的总数量
     * @param professionalId
     * @param courseId
     * @return
     */
    public int getJobExampleStudyByCourse(@Param("professionalId") Integer professionalId, @Param("courseId") Integer courseId);

    /**
     * 根据科目拿到到随机的题目
     * @param professionalId
     * @param courseId
     * @param page
     * @return
     */
    public JobExampleStudy getJobExampleStudyBypProfessionalCourse(@Param("professionalId") Integer professionalId, @Param("courseId") Integer courseId, @Param("page") Integer page);
}
