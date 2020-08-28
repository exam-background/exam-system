package com.yyhn.exam.service;

import com.yyhn.exam.vo.ErrorTechnologyDayExerciseSubmitVO;

import java.util.List;

public interface ErrorTechnologyDayExerciseSubmitService {
    /**
     * 根据条件查询错题
     * @param professionalId
     * @param courseId
     * @param titleName
     * @return
     */
    public List<ErrorTechnologyDayExerciseSubmitVO> getErrorTechnologyDayExercise(Integer professionalId, Integer courseId, String titleName);

    /**
     * 根据题目id查看错误学生
     * @param id
     * @return
     */
    public List<ErrorTechnologyDayExerciseSubmitVO> getTechnologyDayExerciseStudentByErrorId(Integer id);
}
