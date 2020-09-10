package com.yyhn.exam.mapper;

import com.yyhn.exam.vo.TechnologyDayExerciseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface StudentCuoTiMapper {

    @Select(" select s.`title` , s.`standard_answer`, d.`submit_answer` ,d.`score`,types from exam_technology_day_exercise_submit d ,`exam_technology_day_exercise` s  where d.student_id = #{studentId} and d.`right`=0 and s.`id` = d.`exercise_id` and s.`types` = 1 ")
    List<TechnologyDayExerciseVO> getJianDa(@Param("studentId") int studentId);

    @Select(" SELECT s.`title` , (SELECT order_num FROM `exam_technology_day_exercise_item` WHERE content = s.standard_answer) standard_answer,d.submit_answer,(SELECT GROUP_CONCAT('---',m.content) FROM `exam_technology_day_exercise_item` m  WHERE m.exercise_id = 44) items FROM exam_technology_day_exercise_submit d ,`exam_technology_day_exercise` s  WHERE d.student_id = #{studentId} AND d.`right`=0 AND s.`id` = d.`exercise_id` AND s.`types` = 2 ")
    List<TechnologyDayExerciseVO> getXuanZe(@Param("studentId") int studentId);
}
