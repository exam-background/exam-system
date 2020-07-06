package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Teacher;
import com.yyhn.exam.mapper.TeacherMapper;
import com.yyhn.exam.service.TeacherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> getAllTeacherNoPage(String positionName) {
        List<Teacher> teacherList = teacherMapper.getAllTeacherNoPage(positionName);
        return teacherList;
    }

    @Override
    public void getAllTeacher(String teacherName,Integer professionalId , Page<List<Teacher>> page) {
        Map<String,Object> map = new HashMap<>();
        map.put("teacherName",teacherName);
        map.put("professionalId",professionalId);
        map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());
        //根据条件查询课程信息
        List<Teacher> courseList = teacherMapper.getAllTeacher(map);
        int total = teacherMapper.getCount(map);
        page.setData(courseList);
        page.setTotal(total);
    }



    @Override
    public int addTeacher(Teacher teacher) {
        return teacherMapper.addTeacher(teacher);
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return teacherMapper.updateTeacher(teacher);
    }

    @Override
    public int deleteTeacher(int id) {
        return teacherMapper.deleteTeacher(id);
    }
}
