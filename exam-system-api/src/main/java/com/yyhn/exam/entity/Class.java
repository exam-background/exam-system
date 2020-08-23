package com.yyhn.exam.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Class  implements java.io.Serializable{

    private Integer id;
    /**
     * 班级名称
     */
    private String className;

    /**
     * 班级说明
     */
    private String classDesc;


    /**
     * 开班时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date openTime = new Date();

    /**
     * 年级
     */
    private String grade;


    /**
     * 班主任
     */
    @Ignore
    private Teacher classTeacher = new Teacher();

    /**
     * 专业课教员
     */
    @Ignore
    private Teacher professionalTeacher = new Teacher();

    public String toString(){
        return "{ ID :"+id +"\t className:"+className +"\tclassDesc"+classDesc +"\t grade : "+grade +"\t classTeacher : "+classTeacher +"\tprofessionalTeacher :"+professionalTeacher+"}";

    }


    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Teacher getClassTeacher() {
        return classTeacher;
    }

    public void setClassTeacher(Teacher classTeacher) {
        this.classTeacher = classTeacher;
    }

    public Teacher getProfessionalTeacher() {
        return professionalTeacher;
    }

    public void setProfessionalTeacher(Teacher professionalTeacher) {
        this.professionalTeacher = professionalTeacher;
    }
}
