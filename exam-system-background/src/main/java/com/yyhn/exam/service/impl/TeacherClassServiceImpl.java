package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.TeacherClass;
import com.yyhn.exam.mapper.TeacherClassMapper;
import com.yyhn.exam.service.TeacherClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeacherClassServiceImpl implements TeacherClassService {
    @Resource
    private TeacherClassMapper teacherClassMapper;


    @Override
    public List<TeacherClass> getTeacherClass(String teacherName, Integer professionalId) {
        return teacherClassMapper.getTeacherClass(teacherName, professionalId);
    }

    @Override
    public int insertTeacherClass(TeacherClass teacherClass) {
        return teacherClassMapper.insert(teacherClass);
    }

    @Override
    public int deleteTeacherClass(int id) {
        return teacherClassMapper.deleteById(id);
    }

    @Override
    public int updateTeacherClass(TeacherClass teacherClass) {
        return teacherClassMapper.updateById(teacherClass);
    }
}
