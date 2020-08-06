package com.yyhn.exam.entity;

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
    private Integer papers_id;
    /**
     * 题目id
     */
    private Integer iexercise_id;
    /**
     * 用户id
     */
    private Integer user_id;
    /**
     * 用户答案
     */
    private String user_exercise;
    /**
     * 标准答案
     */
    private String papers_exercise;
    /**
     * 用户答案是否正确(1:正确，0错误)
     */
    private Integer right;
}
