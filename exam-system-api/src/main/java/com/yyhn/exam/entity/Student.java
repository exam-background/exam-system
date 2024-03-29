package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@TableName("exam_student")
@JsonIgnoreProperties("papers")
public class Student {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String email;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;


    private String stuName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date openClassTime;
    private Integer classId;
    private Integer professionalId;
    private String loginName;
    private String loginPassword;
    /**
     *  总分
     */
    @TableField(exist = false)
    private float studentScore;
    /**
     * 总得分
     */
    @TableField(exist = false)
    private float countScore;

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    private String detail;

    @TableField(exist = false)
    private Class clazz = new Class();
    @TableField(exist = false)
    private Professional professional = new Professional();
//    @TableField(exist = false)
//    @JsonIgnore
//    private List<Papers> papers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Date getOpenClassTime() {
        return openClassTime;
    }

//    public List<Papers> getPapers() {
//        return papers;
//    }

    public float getStudentScore() {
        return studentScore;
    }

    public void setStudentScore(float studentScore) {
        this.studentScore = studentScore;
    }

    public float getCountScore() {
        return countScore;
    }

    public void setCountScore(float countScore) {
        this.countScore = countScore;
    }

//    public void setPapers(List<Papers> papers) {
//        this.papers = papers;
//    }

    public void setOpenClassTime(Date openClassTime) {
        this.openClassTime = openClassTime;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    public Student(Integer id, String stuName, Date openClassTime, Class clazz, Professional professional, Integer classId, Integer professionalId, String loginName, String loginPassword) {
        this.id = id;
        this.stuName = stuName;
        this.openClassTime = openClassTime;
        this.clazz = clazz;
        this.professional = professional;
        this.classId = classId;
        this.professionalId = professionalId;
        this.loginName = loginName;
        this.loginPassword = loginPassword;
    }

    public Student() {
    }

    @Override
    public String  toString() {
        return "Student{" +
                "id=" + id +
                ", stuName='" + stuName + '\'' +
                ", openClassTime=" + openClassTime +
                ", classId=" + classId +
                ", professionalId=" + professionalId +
                ", loginName='" + loginName + '\'' +
                ", loginPassword='" + loginPassword + '\'' +
                ", clazz=" + clazz +
                ", professional=" + professional +
                '}';
    }
}
