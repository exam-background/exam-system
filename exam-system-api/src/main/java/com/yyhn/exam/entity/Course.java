package com.yyhn.exam.entity;

/**
 * 科目实体类
 */
public class Course  implements java.io.Serializable{

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
