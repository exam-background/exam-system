package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.JobExampleStudy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface JobDayExerciseMapper {

    /**
     * 根据条件获取就业每日一练信息
     * @return
     */
    public List<JobDayExercise> getAllJobDayExercise(Map<String,Object> map);

    /**
     * 获取总记录数
     * @return
     */
    public int getCount(Map<String,Object> map);

    /**
     * 批量删除就业每日一练信息
     * @param list
     * @return
     */
    public int deletesJobDayExercise(List<Integer> list);

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
     * 根据ID 获取就业每日一练信息
     * @param id
     * @return
     */
    public JobDayExercise getJobDayExerciseById(int id);
}
