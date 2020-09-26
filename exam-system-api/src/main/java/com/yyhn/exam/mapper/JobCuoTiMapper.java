package com.yyhn.exam.mapper;

import com.yyhn.exam.vo.TechnologyDayExerciseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface JobCuoTiMapper {
    @Select(" SELECT s.`title` , s.`answer` standard_answer , d.`submit_answer` ,d.`score` FROM `exam_job_day_exercise_submit` d ,`exam_job_day_exercise` s  WHERE d.student_id = #{studentId} AND d.`right`=0 AND s.`id` = d.`exercise_id`")
    List<TechnologyDayExerciseVO> getJobCuoTi(@Param("studentId")int studentId);
}
