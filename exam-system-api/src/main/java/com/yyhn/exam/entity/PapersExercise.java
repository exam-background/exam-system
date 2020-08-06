package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("exam_papers_exercise ")
public class PapersExercise implements Serializable {
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
     * 题目id
     */
    private Integer titleId;
    /**
     * 题目答案
     */
    private String content;
    /**
     * 题目选项
     */
    private String orderNum;

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

    public Integer getTitleId() {
        return titleId;
    }

    public void setTitleId(Integer titleId) {
        this.titleId = titleId;
    }

    public PapersExercise(Integer id, Integer papersId, Integer titleId, String content, String orderNum) {
        this.id = id;
        this.papersId = papersId;
        this.titleId = titleId;
        this.content = content;
        this.orderNum = orderNum;
    }

    public PapersExercise() {
    }

    @Override
    public String toString() {
        return "PapersExercise{" +
                "id=" + id +
                ", papersId=" + papersId +
                ", titleId=" + titleId +
                ", content='" + content + '\'' +
                ", orderNum='" + orderNum + '\'' +
                '}';
    }
}
