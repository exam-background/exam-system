package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.vo.ClassCuoTiVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AppClassMapper {
    @Select("select * from exam_class where class_teacher_id = #{id}")
    List<Class> getBanClass(@Param("id") int id);

    @Select("select * from exam_class where Professional_teacher_id = #{id}")
    List<Class> getJiaoClass(@Param("id") int id);

    @Select("select * from exam_student where class_id = #{id}")
    List<Student> getStudentListByClassId(@Param("id") int id);


}
