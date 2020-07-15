package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;
import java.util.Arrays;
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
     * 专业id
     */
    private Integer professionalId;

    /**
     * 对应专业
     */
    private Professional professional = new Professional();

    private Integer radio;

    /**
     * 对应科目
     */
    private Course course = new Course();

    /**
     * 科目id
     */
    private String courseId;

    /**
     * 备注
     */
    private String remark;

    public Integer getRadio() {
        return radio;
    }

    public void setRadio(Integer radio) {
        this.radio = radio;
    }

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

    private String[] redioItem;

    public String[] getRedioItem() {
        return redioItem;
    }

    public void setRedioItem(String[] redioItem) {
        this.redioItem = redioItem;
    }

    /**
     *每日一练作答信息
     */
    private List<TechnologyDayExerciseSubmit> submitList = new ArrayList<TechnologyDayExerciseSubmit>();

    private SysDictionary sysDictionary = new SysDictionary();

    public SysDictionary getSysDictionary() {
        return sysDictionary;
    }

    public void setSysDictionary(SysDictionary sysDictionary) {
        this.sysDictionary = sysDictionary;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

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

    @Override
    public String toString() {
        return "TechnologyDayExercise{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", types='" + types + '\'' +
                ", standardAnswer='" + standardAnswer + '\'' +
                ", setScore=" + setScore +
                ", analysis='" + analysis + '\'' +
                ", professionalId=" + professionalId +
                ", professional=" + professional +
                ", radio=" + radio +
                ", course=" + course +
                ", courseId='" + courseId + '\'' +
                ", remark='" + remark + '\'' +
                ", buildExerciseDate=" + buildExerciseDate +
                ", updateExerciseDate=" + updateExerciseDate +
                ", exerciseItems=" + exerciseItems +
                ", redioItem=" + Arrays.toString(redioItem) +
                ", submitList=" + submitList +
                ", sysDictionary=" + sysDictionary +
                '}';
    }
}
