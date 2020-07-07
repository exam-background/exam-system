package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Teacher;
import com.yyhn.exam.entity.TechnologyDayExercise;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TechnologyDayExerciseMapper {

    /**
     * 根据条件获取每日一练信息
     * @return
     */
    public List<TechnologyDayExercise> getAllTechnologyDayExercise(Map<String,Object> map);

    /**
     * 获取记录数
     * @return
     */
    public int getCount(Map<String,Object> map);

    /**
     * 添加每日一练信息
     * @return
     */
    public int addTechnologyDayExercise(TechnologyDayExercise technologyDayExercise);

    /**
     * 修改每日一练信息
     * @return
     */
    public int updateTechnologyDayExercise(TechnologyDayExercise technologyDayExercise);

    /**
     * 根据ID 删除每日一练信息
     * @return
     */
    public int deleteTechnologyDayExercise(@Param("id") int id);

    /**
     * 根据ID 获取每日一练信息
     * @param id
     * @return
     */
    public TechnologyDayExercise getTechnologyDayExerciseById(@Param("id") int id);

}