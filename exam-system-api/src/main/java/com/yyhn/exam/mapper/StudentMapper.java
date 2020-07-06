package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Student;
import com.yyhn.exam.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /**
     * 获取所有的学生信息，不分页显示
     * @return
     */
    public List<Student> getAllStudentNoPage();

    /**
     * 根据条件获取学生信息
     * @return
     */
    public List<Student> getAllStudent(Map<String, Object> map);


    /**
     * 获取记录数
     * @return
     */
    public int getCount(Map<String, Object> map);

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
     * 根据ID 删除学生信息
     * @return
     */
    public int deleteStudent(int id);
}
