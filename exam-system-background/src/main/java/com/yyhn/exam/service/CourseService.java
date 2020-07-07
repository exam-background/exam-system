package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Course;


import java.util.List;

public interface CourseService {
    /**
     * 分页
     * @param courseName
     * @param page
     */
    public void getCourse(String courseName, Page<List<Course>> page);
    /**
     * 添加课程信息
     * @return
     */
    public int addCourse(Course course);

    /**
     * 修改课程信息
     * @return
     */
    public int updateCourse(Course course);

    /**
     * 删除课程信息
     * @return
     */
    public int deleteCourse(int id);

}