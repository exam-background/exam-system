package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.ArrayList;
import java.util.List;

@TableName("exam_teacher_class")
public class TeacherClass {
    /**
     * 主键，id
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 外键，教师id
     */
    private Integer teacherId;
    /**
     * 外键，班级id
     */
    private Integer classId;
    /**
     * 外键，班级科目
     */
    private Integer professionalId;

    /**
     * 关联教师信息
     */
    @TableField(exist = false)
    private Teacher teacher;
    /**
     * 关联班级信息
     */
    @TableField(exist = false)
    private Class classList;
    /**
     * 班级所属专业
     */
    @TableField(exist = false)
    private Professional professional = new Professional();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Class getClassList() {
        return classList;
    }

    public void setClassList(Class classList) {
        this.classList = classList;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public TeacherClass() {
    }

    public TeacherClass(Integer id, Integer teacherId, Integer classId, Integer professionalId, Teacher teacher, Class classList, Professional professional) {
        this.id = id;
        this.teacherId = teacherId;
        this.classId = classId;
        this.professionalId = professionalId;
        this.teacher = teacher;
        this.classList = classList;
        this.professional = professional;
    }

    @Override
    public String toString() {
        return "TeacherClass{" +
                "id=" + id +
                ", teacherId=" + teacherId +
                ", classId=" + classId +
                ", professionalId=" + professionalId +
                ", teacher=" + teacher +
                ", classList=" + classList +
                ", professional=" + professional +
                '}';
    }
}
