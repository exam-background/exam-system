package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper {

    /**
     * 根据条件获取课程信息
     * @return
     */
    public List<Course> getAllCourse(Map<String,Object> map);


    /**
     * 获取记录数
     * @return
     */
    public int getCount(Map<String,Object> map);

    /**
     * 增加课程信息
     * @return
     */
    public int addCourse(Course course);

    /**
     * 修改课程信息
     * @return
     */
    public int updateCourse(Course course);

    /**
     * 根据ID删除课程信息
     * @return
     */
    public int deleteCourse(int id);
}
