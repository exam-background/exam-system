package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.JobExampleStudy;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 就业每日一练业务逻辑类
 *
 */

public interface JobDayExerciseService {

    /**
     * 根据条件获取就业每日一练信息
     * @return
     */
    public void getAllJobDayExercise(String title, Integer professionalId, Integer courseId, Page<List<JobDayExercise>> page);

    /**
     * 查询所有就业每日一练信息
     * @param jobDayExercise
     * @return
     */
    public List<JobDayExercise> getAllJobDayExercise(String title, Integer professionalId, Integer courseId);

    /**
     * 批量删除就业每日一练信息
     * @param list
     * @return
     */
    public int deletesJobDayExercise(List<JobDayExercise> list);

    /**
     * 增加就业每日一练信息
     * @return
     */
    public int addJobDayExercise(JobDayExercise jobDayExercise);


    /**
     * 修改就业每日一练信息
     * @return
     */
    public int updateJobDayExercise(JobDayExercise jobDayExercise);


    /**
     * 删除就业每日一练信息
     * @return
     */
    public int deleteJobDayExercise(int id);

    /**
     * 根据科目id查询所有题目
     * @param professionalId
     * @return
     */
    public List<JobDayExercise> getJobDayExerciseByProfessionalId(Integer professionalId);

    /**
     * 根据题目id查询题目信息
     * @param id
     * @return
     */
    public JobDayExercise getJobDayExerciseById(Integer id);

    /**
     * 获取题库中该科目的总数量
     * @param professionalId
     * @param courseId
     * @return
     */
    public int getJobDayExerciseByCourse(Integer professionalId, Integer courseId);

    /**
     * 根据科目拿到到随机的题目
     * @param professionalId
     * @param courseId
     * @param page
     * @return
     */
    public JobDayExercise getJobDayExerciseBypProfessionalCourse(Integer professionalId, Integer courseId, Integer page);
}
