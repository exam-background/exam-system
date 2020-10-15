package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@TableName("exam_papers_title")
public class PapersTitle implements Serializable {
    /**
     * id，主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 外键，试卷id
     */
    private Integer papersId;
    /**
     * 题目内容
     */
    private String title;
    /**
     * 解析
     */
    private String analysis;
    /**
     * 分值
     */
    private Integer setScore;
    /**
     * 标准答案
     */
    private String standardAnswer;
    /**
     * 题目类型
     */
    private Integer types;

    /**
     * 题目备选答案
     */
    @TableField(exist = false)
    private List<PapersExercise> papersExercises = new ArrayList<PapersExercise>();

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    public Integer getSetScore() {
        return setScore;
    }

    public void setSetScore(Integer setScore) {
        this.setScore = setScore;
    }

    public String getStandardAnswer() {
        return standardAnswer;
    }

    public void setStandardAnswer(String standardAnswer) {
        this.standardAnswer = standardAnswer;
    }

    public List<PapersExercise> getPapersExercises() {
        return papersExercises;
    }

    public void setPapersExercises(List<PapersExercise> papersExercises) {
        this.papersExercises = papersExercises;
    }

    public Integer getTypes() {
        return types;
    }

    public void setTypes(Integer types) {
        this.types = types;
    }

    public PapersTitle() {
    }

    public PapersTitle(Integer id, Integer papersId, String title, String analysis, Integer setScore, String standardAnswer, Integer types) {
        this.id = id;
        this.papersId = papersId;
        this.title = title;
        this.analysis = analysis;
        this.setScore = setScore;
        this.standardAnswer = standardAnswer;
        this.types = types;
    }

    @Override
    public String toString() {
        return "PapersTitle{" +
                "id=" + id +
                ", papersId=" + papersId +
                ", title='" + title + '\'' +
                ", analysis='" + analysis + '\'' +
                ", setScore=" + setScore +
                ", standardAnswer='" + standardAnswer + '\'' +
                ", types=" + types +
                ", papersExercises=" + papersExercises +
                '}';
    }
}
