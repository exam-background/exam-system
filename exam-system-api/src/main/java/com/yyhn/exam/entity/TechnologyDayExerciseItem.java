package com.yyhn.exam.entity;

/**
 * 每日一练题目的答案备选项
 */
public class TechnologyDayExerciseItem {
    /**
     * ID
     */
    private int id;

    /**
     * 内容
     */
    private String content;

    /**
     * 所属技术每日一练ID
     */
    private Integer exerciseId;

    /**
     * 排序号
     */
    private String orderNum;


    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
