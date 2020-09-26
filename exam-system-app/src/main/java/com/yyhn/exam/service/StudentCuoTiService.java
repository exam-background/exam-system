package com.yyhn.exam.service;

import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.vo.ClassCuoTiVo;
import com.yyhn.exam.vo.TechnologyDayExerciseVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentCuoTiService {
    List<TechnologyDayExerciseVO> getJianDa(@Param("studentId") int studentId);

    List<TechnologyDayExerciseVO> getXuanZe(@Param("studentId") int studentId);

    List<TechnologyDayExerciseVO> getJobCuoTi(@Param("studentId") int studentId);

    List<TechnologyDayExerciseVO> getPaperJianDa(@Param("studentId") int studentId);

    List<ClassCuoTiVo> getCuoTiCount(@Param("id") int id);
}
