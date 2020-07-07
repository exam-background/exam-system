package com.yyhn.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 技术每日一练题目
 */
public class TechnologyDayExercise {
    /**
     * ID
     */
    private int id;

    /**
     * 题目题干
     */
    private String title;

    /**
     * 题型
     */
    private String types;


    /**
     * 题目标准答案
     */
    private String standardAnswer;

    /**
     * 题目设置的分值
     */
    private int setScore;

    /**
     * 试题分析
     */
    private String analysis;

    /**
     * 对应专业
     */
    private Professional professional = new Professional();

    /**
     * 对应科目
     */
    private Course course = new Course();

    /**
     * 备注
     */
    private String remark;

    /**
     * 试题创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date buildExerciseDate = new Date();

    /**
     * 试题修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date updateExerciseDate= new Date();

    /**
     * 每日一练备选答案选项
     */
    private List<TechnologyDayExerciseItem> exerciseItems = new ArrayList<TechnologyDayExerciseItem>();

    /**
     *每日一练作答信息
     */
    private List<TechnologyDayExerciseSubmit> submitList = new ArrayList<TechnologyDayExerciseSubmit>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    public int getSetScore() {
        return setScore;
    }

    public void setSetScore(int setScore) {
        this.setScore = setScore;
    }

    public List<TechnologyDayExerciseSubmit> getSubmitList() {
        return submitList;
    }

    public void setSubmitList(List<TechnologyDayExerciseSubmit> submitList) {
        this.submitList = submitList;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getBuildExerciseDate() {
        return buildExerciseDate;
    }

    public void setBuildExerciseDate(Date buildExerciseDate) {
        this.buildExerciseDate = buildExerciseDate;
    }

    public Date getUpdateExerciseDate() {
        return updateExerciseDate;
    }

    public void setUpdateExerciseDate(Date updateExerciseDate) {
        this.updateExerciseDate = updateExerciseDate;
    }

    public List<TechnologyDayExerciseItem> getExerciseItems() {
        return exerciseItems;
    }

    public void setExerciseItems(List<TechnologyDayExerciseItem> exerciseItems) {
        this.exerciseItems = exerciseItems;
    }
}