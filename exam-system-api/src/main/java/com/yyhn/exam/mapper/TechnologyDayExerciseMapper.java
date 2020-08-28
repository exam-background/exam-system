package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.vo.ErrorTechnologyDayExerciseSubmitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TechnologyDayExerciseMapper extends BaseMapper<TechnologyDayExercise>{

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
     * 删除多个每日一练
     * @param list
     * @return
     */
    public int deleteTechnologyDayExercises(List<Integer> list);

    /**
     * 根据ID 获取每日一练信息
     * @param id
     * @return
     */
    public TechnologyDayExercise getTechnologyDayExerciseById(@Param("id") int id);

    /**
     * 获取题库中该科目的总数量
     * @param professionalId
     * @param courseId
     * @return
     */
    public int getTechnologyDayExerciseByCourse(@Param("professionalId") Integer professionalId, @Param("courseId") Integer courseId);

    /**
     * 根据科目拿到到随机的题目
     * @param professionalId
     * @param courseId
     * @param page
     * @return
     */
    public TechnologyDayExercise getTechnologyDayExerciseBypProfessionalCourse(@Param("professionalId") Integer professionalId, @Param("courseId") Integer courseId, @Param("page") Integer page);
}
