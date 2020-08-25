package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.mapper.StudentMapper;
import com.yyhn.exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    StudentMapper studentMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Student> getAllStudentNoPage() {
        List<Student> studentList = studentMapper.getAllStudentNoPage();
        return studentList;
    }

    @Override
    public void getAllStudent(Integer professionalId, Integer classId,String stuName, Page<List<Student>> page) {
        Map<String,Object> map = new HashMap<>();
        map.put("stuName",stuName);
        map.put("professionalId",professionalId);
        map.put("classId",classId);
        map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());
        //根据条件查询课程信息
        List<Student> courseList = studentMapper.getAllStudent(map);
        int total = studentMapper.getCount(map);
        page.setData(courseList);
        page.setTotal(total);
    }

    @Override
    public int addStudent(Student student) {
        System.out.println("9999999999999999999999999---"+student.getLoginName());
        student.setLoginPassword(passwordEncoder.encode(student.getLoginPassword()));
        int count = studentMapper.addStudent(student);
        return count;
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public int deleteStudent(int id) {
        return studentMapper.deleteStudent(id);
    }
}
