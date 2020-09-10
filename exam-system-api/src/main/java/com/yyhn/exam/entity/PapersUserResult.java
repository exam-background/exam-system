package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("exam_papers_user_result")
public class PapersUserResult implements Serializable {
    /**
     * id,主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 试卷id
     */
    private Integer papersId;
    /**
     * 题目id
     */
    private Integer exerciseId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 用户答案
     */
    private String userExercise;
    /**
     * 标准答案
     */
    private String papersExercise;
    /**
     * 用户答案是否正确(1:正确，0错误)
     */
    private Integer right;
    /**
     * 分值
     */
    private Integer setScore;
    /**
     * 实际分数
     */
    private float mark;

    /**
     * 与学生答案对应的题目外键
     */
    private PapersTitle papersTitle;

    /**
     * 学生信息
     */
    @TableField(exist = false)
    private Student student;

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

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserExercise() {
        return userExercise;
    }

    public void setUserExercise(String userExercise) {
        this.userExercise = userExercise;
    }

    public String getPapersExercise() {
        return papersExercise;
    }

    public void setPapersExercise(String papersExercise) {
        this.papersExercise = papersExercise;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public PapersTitle getPapersTitle() {
        return papersTitle;
    }

    public void setPapersTitle(PapersTitle papersTitle) {
        this.papersTitle = papersTitle;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(float mark) {
        this.mark = mark;
    }

    public Integer getSetScore() {
        return setScore;
    }

    public void setSetScore(Integer setScore) {
        this.setScore = setScore;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }


    public PapersUserResult(Integer id, Integer papersId, Integer exerciseId, Integer userId, String userExercise, String papersExercise, Integer right, Integer setScore, Integer mark) {
        this.id = id;
        this.papersId = papersId;
        this.exerciseId = exerciseId;
        this.userId = userId;
        this.userExercise = userExercise;
        this.papersExercise = papersExercise;
        this.right = right;
        this.setScore = setScore;
        this.mark = mark;
    }

    public PapersUserResult() {
    }

    @Override
    public String toString() {
        return "PapersUserResult{" +
                "id=" + id +
                ", papersId=" + papersId +
                ", exerciseId=" + exerciseId +
                ", userId=" + userId +
                ", userExercise='" + userExercise + '\'' +
                ", papersExercise='" + papersExercise + '\'' +
                ", right=" + right +
                ", papersTitle=" + papersTitle +
                ", setScore=" + setScore +
                '}';
    }
}
