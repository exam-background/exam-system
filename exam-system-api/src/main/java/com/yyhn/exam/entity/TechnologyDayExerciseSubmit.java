package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

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
     * 提交时间
     */
    private Date submitDate;

    /**
     * 得分
     */
    private int score;

    /**
     * 学生id
     */
    private int studentId;

    /**
     * 题目id
     */
    private int exerciseId;

    /**
     * 题目是否正确
     */
    private int right;

    /**
     * 学生
     */
    @TableField(exist = false)
    private Student student = new Student();

    /**
     * 所属每日一练题目
     */
    @TableField(exist = false)
    private TechnologyDayExercise technologyDayExercise = new TechnologyDayExercise();

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

    public Date getSubmitDate() {
        return submitDate;
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

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getExerciseId() {
        return exerciseId;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public void setExerciseId(int exerciseId) {
        this.exerciseId = exerciseId;
    }
}
