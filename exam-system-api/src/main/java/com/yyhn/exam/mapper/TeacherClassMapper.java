package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.TeacherClass;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherClassMapper extends BaseMapper<TeacherClass> {
    /**
     * 根据条件查询教师关联班级信息
     * @param teacherName
     * @param professionalId
     * @return
     */
    List<TeacherClass> getTeacherClass(@Param("teacherName") String teacherName, @Param("professionalId") Integer professionalId);
}
