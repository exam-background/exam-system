package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper extends BaseMapper<Student>  {

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
     * 修改学生信息
     * @return
     */
    public int updateStudent(Student student);

    /**
     * 根据ID 删除学生信息
     * @return
     */
    public int deleteStudent(int id);

    Student doLogin(String loginName);
    @Select("select login_password from exam_student where id = #{id}")
    String getLoginPassword(int id);
    @Insert("update exam_student set login_password = #{newPassword} where id = #{id}")
    int updatePassword(@Param("id") int id ,@Param("newPassword") String newPassword);


    @Select("select email from exam_student where login_name = #{loginName}")
    String getEmailByLoginName(String loginName);
    @Update("update exam_student set login_password = #{loginPassword} where login_name = #{loginName}")
    int updatePasswordByName(@Param("loginName")String loginName,@Param("loginPassword")String loginPassword);

}
