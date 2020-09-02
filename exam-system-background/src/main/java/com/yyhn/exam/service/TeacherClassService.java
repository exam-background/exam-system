package com.yyhn.exam.service;

import com.yyhn.exam.entity.TeacherClass;

import java.util.List;

public interface TeacherClassService {
    /**
     * 根据条件查询教师关联班级信息
     * @param teacherName
     * @param professionalId
     * @return
     */
    List<TeacherClass> getTeacherClass(String teacherName, Integer professionalId);

    /**
     * 添加教师关联班级信息
     * @param teacherClass
     * @return
     */
    int insertTeacherClass(TeacherClass teacherClass);

    /**
     * 删除教师关联班级信息
     * @param id
     * @return
     */
    int deleteTeacherClass(int id);

    /**
     * 修改教师关联班级信息
     * @param teacherClass
     * @return
     */
    int updateTeacherClass(TeacherClass teacherClass);
}
