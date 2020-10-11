package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Teacher;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper {

  /**
   * 获取所有的老师信息，不分页显示
   *
   * @return
   */
  public List<Teacher> getAllTeacherNoPage(@Param("positionName") String positionName);
  /**
   * 根据条件获取老师信息
   *
   * @return
   */
  public List<Teacher> getAllTeacher(Map<String, Object> map);

  /**
   * 获取记录数
   *
   * @return
   */
  public int getCount(Map<String, Object> map);

  /**
   * 添加老师信息
   *
   * @return
   */
  public int addTeacher(Teacher teacher);

  /**
   * 修改老师信息
   *
   * @return
   */
  public int updateTeacher(Teacher teacher);

  /**
   * 根据ID 删除老师信息
   *
   * @return
   */
  public int deleteTeacher(int id);

  @Select("select * from exam_teacher where login_name = #{loginName} and teacher_position = '班主任'")
  public Teacher banLogin(@Param("loginName") String loginName);

  @Select("select * from exam_teacher where login_name = #{loginName} and teacher_position = '教员'")
  public Teacher jiaoLogin(@Param("loginName") String loginName);

  @Select("select email from exam_teacher where id = #{id}")
  String getEmailById(int id);

  @Select("select email from exam_teacher where login_name = #{loginName}")
  String getEmailByLoginName(String loginName);

  @Update(
      "update exam_teacher set login_password = #{loginPassword} where login_name = #{loginName}")
  int updatePasswordByName(
      @Param("loginName") String loginName, @Param("loginPassword") String loginPassword);

  @Select(
      "SELECT t.`teacher_name`, t.`teacher_position`,p.`professional_name`  FROM exam_teacher t , "
          + "exam_professional p WHERE t.`professional_id` = p.`id` AND t.id = #{id}")
  Teacher getTeacherById(@Param("id") int id);

  @Insert("update exam_teacher set login_password = #{newPassword} where id = #{id}")
  int updatePassword(@Param("id") int id, @Param("newPassword") String newPassword);
}
