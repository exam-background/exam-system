package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {

    /**
     * 获取所有的老师信息，不分页显示
     * @return
     */
    public List<Teacher> getAllTeacherNoPage(@Param("positionName") String positionName);
    /**
     * 根据条件获取老师信息
     * @return
     */
    public List<Teacher> getAllTeacher(Map<String,Object> map);




    /**
     * 获取记录数
     * @return
     */
    public int getCount(Map<String,Object> map);

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
     * 根据ID 删除老师信息
     * @return
     */
    public int deleteTeacher(int id);
}
