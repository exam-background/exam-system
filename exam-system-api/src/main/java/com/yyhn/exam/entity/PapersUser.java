package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("exam_papers_user")
public class PapersUser implements Serializable {


    /**
     * id，主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 试卷id
     */
    private Integer papersId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 正确题目数
     */
    private Integer rightExercise;
    /**
     * 错误题目数
     */
    private Integer errorExercise;
    /**
     * 题目总数
     */
    private Integer count;
    /**
     * 是否考试
     */
    private Integer isPapers = 0;

    /**
     * 学生信息
     */
    @TableField(exist = false)
    private Student student = new Student();
    /**
     * 试卷信息
     */
    @TableField(exist = false)
    private Papers papers = new Papers();
    /**
     * 专业信息
     */
    @TableField(exist = false)
    private Professional professional = new Professional();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPapersId() {
        return papersId;
    }

    public void setPapersId(Integer papersId) {
        this.papersId = papersId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRightExercise() {
        return rightExercise;
    }

    public void setRightExercise(Integer rightExercise) {
        this.rightExercise = rightExercise;
    }

    public Integer getErrorExercise() {
        return errorExercise;
    }

    public void setErrorExercise(Integer errorExercise) {
        this.errorExercise = errorExercise;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Papers getPapers() {
        return papers;
    }

    public void setPapers(Papers papers) {
        this.papers = papers;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Integer getIsPapers() {
        return isPapers;
    }

    public void setIsPapers(Integer isPapers) {
        this.isPapers = isPapers;
    }

    public PapersUser(Integer id, Integer papersId, Integer userId, Integer rightExercise, Integer errorExercise, Integer count) {
        this.id = id;
        this.papersId = papersId;
        this.userId = userId;
        this.rightExercise = rightExercise;
        this.errorExercise = errorExercise;
        this.count = count;
    }

    public PapersUser() {
    }

    @Override
    public String toString() {
        return "PapersUser{" +
                "id=" + id +
                ", papersId=" + papersId +
                ", userId=" + userId +
                ", rightExercise=" + rightExercise +
                ", errorExercise=" + errorExercise +
                ", count=" + count +
                '}';
    }
}
