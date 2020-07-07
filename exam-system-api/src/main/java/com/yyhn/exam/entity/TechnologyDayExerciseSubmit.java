package com.yyhn.exam.entity;

import java.util.Date;

/**
 * 技术每日一练作答
 */
public class TechnologyDayExerciseSubmit {

    /**
     * ID
     */
    private int id;

    /**
     * 所属每日一练题目
     */
    private TechnologyDayExercise technologyDayExercise = new TechnologyDayExercise();

    /**
     * 学生
     */
    private Student student;

    /**
     * 提交的答案
     */
    private String submitAnswer;

    /**
     * 提交时间
     */
    private Date submitDate;

    /**
     * 得分
     */
    private int score;

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
