package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppTechnologyDayExerciseMapper extends BaseMapper<TechnologyDayExercise> {
    public List<TechnologyDayExercise> getTechnologyDayExerciseSubmit(@Param("id") Integer id,@Param("studentid") Integer studentid, @Param("startRow") Integer startRow, @Param("pageSize") Integer pageSize);

    public int getTechnologyDayExerciseSubmitCount(@Param("id") Integer id);
}
