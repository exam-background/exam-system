package com.yyhn.exam.vo;

import com.yyhn.exam.entity.TechnologyDayExercise;

public class TechnologyDayExerciseVO extends TechnologyDayExercise {
    private Integer exerciseId;
    private String content;
    private String orderNum;

    public Integer getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(Integer exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }
}
