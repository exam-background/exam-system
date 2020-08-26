package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 科目实体类
 */
@TableName("exam_course")
public class Course  implements java.io.Serializable{
    @TableId(value = "id",type = IdType.AUTO)
    private  Integer id;
    /**
     * 科目名称
     */
    private  String courseName;
    /**
     * 科目描述
     */
    private  String courseDesc;

    /**
     * 所属专业
     */
    @TableField(exist = false)
    private  Professional professional = new Professional();

    public String toString(){
        return "{ course ID: "+ id +"\t courseName : "+courseName +"\t courseDesc : "+courseDesc +"}";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
