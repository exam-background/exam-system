package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Teacher;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TechnologyDayExerciseItemMapper {

    /**
     * 添加每日一练备选选项信息
     * @return
     */
    public int addTechnologyDayExerciseItem(TechnologyDayExerciseItem technologyDayExerciseItem);

    /**
     * 修改每日一练备选选项信息
     * @return
     */
    public int updateTechnologyDayExerciseItem(TechnologyDayExerciseItem technologyDayExerciseItem);

    /**
     * 根据ID 删除每日一练备选选项信息
     * @return
     */
    public int deleteTechnologyDayExerciseItem(int id);



    /**
     * 根据技术每日一练ID 获取每日一练备选选项信息
     * @param technologyDayExerciseId
     * @return
     */
    public List<TechnologyDayExerciseItem> getItemByTechnologyDayExerciseId(@Param("technologyDayExerciseId") int technologyDayExerciseId);


    /**
     * 根据ID 获取每日一练备选选项信息
     * @param id
     * @return
     */
    public TechnologyDayExerciseItem getTechnologyDayExerciseById(@Param("id") int id);

    /**
     * 根据ID 获取每日一练备选选项信息
     * @param id
     * @return
     */
    public List<TechnologyDayExerciseItem> getTechnologyDayExerciseByExerciseId(@Param("id") int id);

}
