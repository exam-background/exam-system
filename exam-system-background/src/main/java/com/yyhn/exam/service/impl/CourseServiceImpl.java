package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Course;
import com.yyhn.exam.entity.Professional;
import com.yyhn.exam.mapper.CourseMapper;
import com.yyhn.exam.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService {
    @Resource
    private CourseMapper courseMapper;

    /**
     * 分页查询课程信息
     * @param couseName
     * @param page
     */
    @Override
    public void getCourse(String couseName, Page<List<Course>> page) {
        Map<String,Object> map = new HashMap<>();
        map.put("courseName",couseName);
        map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());

        System.out.println("MAP : "+map);
        //根据条件查询课程信息
        List<Course> courseList = courseMapper.getAllCourse(map);
        int total = courseMapper.getCount(map);
        System.out.println(" courseList: "+courseList +"\t total : "+total);
        page.setData(courseList);
        page.setTotal(total);

    }

    @Override
    public int addCourse(Course course) {
        return courseMapper.addCourse(course);
    }

    @Override
    public int updateCourse(Course course) {
        return courseMapper.updateCourse(course);
    }

    @Override
    public int deleteCourse(int id) {
        return courseMapper.deleteCourse(id);
    }
}
