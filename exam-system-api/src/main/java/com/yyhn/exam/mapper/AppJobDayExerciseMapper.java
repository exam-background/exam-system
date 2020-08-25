package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.JobDayExercise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppJobDayExerciseMapper extends BaseMapper<JobDayExercise> {

    /**
     * 根据科目id查询题目信息
     * @param id
     * @return
     */
    public List<JobDayExercise> getJobDayExerciseByProfessid(@Param("id") Integer id, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    public int getJobDayExerciseByCount(@Param("id") Integer id);
}
