package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * 获取所有的学生信息，不分页显示
     * @return
     */
    public List<Student> getAllStudentNoPage();

    /**
     * 分页
     * @param stuName
     * @param page
     */
    public void getAllStudent(Integer professionalId, Integer classId,String stuName, Page<List<Student>> page);

    /**
     * 添加学生信息
     * @return
     */
    public int addStudent(Student student);

    /**
     * 修改学生信息
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 删除学生信息
     * @return
     */
    public int deleteStudent(int id);

    /**
     * 根据班级查询学生id
     */
    public List<Student> selectStudent(Integer Id);
}
