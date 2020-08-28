package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.vo.ErrorTechnologyDayExerciseSubmitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ErrorTechnologyDayExerciseSubmitMapper extends BaseMapper<ErrorTechnologyDayExerciseSubmitVO> {

    /**
     * 根据科目id，专业id，题目名称拿到错题
     * @param professionalId
     * @param courseId
     * @param titleName
     * @return
     */
    public List<ErrorTechnologyDayExerciseSubmitVO> getErrorTechnologyDayExercise(@Param("professionalId") Integer professionalId, @Param("courseId") Integer courseId, @Param("titleName") String titleName);

    /**
     * 根据题目id查询错误题目数量
     * @param exerciseId
     * @return
     */
    public int getErrorTechnologyDayExerciseCount(Integer exerciseId);

    /**
     * 根据题目id查询正确题目数量
     * @param exerciseId
     * @return
     */
    public int getTechnologyDayExerciseCount(Integer exerciseId);

    /**
     * 根据题目id查看错误学生
     * @param id
     * @return
     */
    public List<ErrorTechnologyDayExerciseSubmitVO> getTechnologyDayExerciseStudentByErrorId(Integer id);
}
