package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

@TableName("exam_papers_course")
public class PapersCourse implements Serializable {
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
     * 科目id
     */
    private Integer courseId;
    /**
     * 专业id
     */
    private Integer professionalId;

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

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public PapersCourse(Integer id, Integer papersId, Integer courseId, Integer professionalId) {
        this.id = id;
        this.papersId = papersId;
        this.courseId = courseId;
        this.professionalId = professionalId;
    }

    public PapersCourse() {
    }

    @Override
    public String toString() {
        return "PapersCourse{" +
                "id=" + id +
                ", papersId=" + papersId +
                ", courseId=" + courseId +
                ", professionalId=" + professionalId +
                '}';
    }
}
