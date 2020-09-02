package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 技术每日一练作答
 */

@TableName("exam_technology_day_exercise_submit")
public class TechnologyDayExerciseSubmit {

    /**
     * ID
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int id;

    /**
     * 作答人id
     */
    private Integer studentId;

    /**
     * 做的题目id
     */
    private Integer exerciseId;

    /**
     * 所属每日一练题目
     */
    @TableField(exist = false)
    private TechnologyDayExercise technologyDayExercise = new TechnologyDayExercise();

    /**
     * 学生
     */
    @TableField(exist = false)
    private Student student;

    /**
     * 提交的答案
     */
    private String submitAnswer;

    /**
     * 提交时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date submitDate = new Date();

    /**
     * 得分
     */
    private int score;

    /**
     * 是否正确
     */
    private Integer right;

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TechnologyDayExercise getTechnologyDayExercise() {
        return technologyDayExercise;
    }

    public void setTechnologyDayExercise(TechnologyDayExercise technologyDayExercise) {
        this.technologyDayExercise = technologyDayExercise;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getSubmitAnswer() {
        return submitAnswer;
    }

    public void setSubmitAnswer(String submitAnswer) {
        this.submitAnswer = submitAnswer;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public Integer getRight() {
        return right;
    }

    public void setRight(Integer right) {
        this.right = right;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
