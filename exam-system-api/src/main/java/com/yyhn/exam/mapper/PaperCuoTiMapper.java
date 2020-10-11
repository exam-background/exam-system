package com.yyhn.exam.mapper;

import com.yyhn.exam.vo.ClassCuoTiVo;
import com.yyhn.exam.vo.TechnologyDayExerciseVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import java.util.List;


@Mapper
public interface PaperCuoTiMapper {
    @Select(" SELECT t.`title`,t.`standard_answer`,u.`user_exercise` submit_answer FROM `exam_papers_user` pu , exam_papers s , exam_papers_title t ,`exam_papers_user_result` u WHERE s.`id` = pu.`papers_id` AND pu.`user_id` = #{studentId} AND t.`papers_id` = s.`id`  AND u.`exercise_id` = t.`id`")
    List<TechnologyDayExerciseVO> getJianDa(@Param("studentId") int studentId);

  @Select("select (SELECT exam_technology_day_exercise.`id` FROM exam_technology_day_exercise WHERE exam_technology_day_exercise.`id` = exercise_id) id,(SELECT exam_technology_day_exercise.`standard_answer` FROM exam_technology_day_exercise WHERE exam_technology_day_exercise.`id` = exercise_id) standard, (SELECT  exam_technology_day_exercise.`title`  FROM exam_technology_day_exercise WHERE exam_technology_day_exercise.`id` = exercise_id) title, count(*) `count`  from `exam_technology_day_exercise_submit` s  where s.`right` = 0  and s.`student_id` in  (select   id  from exam_student  where exam_student.`class_id` in  (SELECT  id  FROM exam_class where Professional_teacher_id = #{id})) GROUP BY exercise_id")
  List<ClassCuoTiVo> getCuoTiCount(@Param("id") int id);
}
