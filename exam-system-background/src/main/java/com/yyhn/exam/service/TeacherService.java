package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherService {



    /**
     * 获取所有的老师信息，不分页显示
     * @return
     */
    public List<Teacher> getAllTeacherNoPage(String positionName);

    /**
     * 分页
     * @param teacherName
     * @param professionalId
     * @param page
     */
    public void getAllTeacher(String teacherName,Integer professionalId, Page<List<Teacher>> page);

    /**
     * 添加老师信息
     * @return
     */
    public int addTeacher(Teacher teacher);

    /**
     * 修改老师信息
     * @return
     */
    public int updateTeacher(Teacher teacher);

    /**
     * 删除老师信息
     * @return
     */
    public int deleteTeacher(int id);

}