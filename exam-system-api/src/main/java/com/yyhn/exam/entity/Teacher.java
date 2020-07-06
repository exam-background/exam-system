package com.yyhn.exam.entity;

public class Teacher implements java.io.Serializable {
    /**
     * ID
     */
    private Integer id;
    /**
     * 老师名称
     */
    private String teacherName;
    /**
     * 老师描述
     */
    private String teacherDesc;

    /**
     * 老师所属职位
     */
    private String teacherPosition;
    /**
     * 老师所属专业
     */
    private Professional professional = new Professional();

    public String getTeacherPosition() {
        return teacherPosition;
    }

    public void setTeacherPosition(String teacherPosition) {
        this.teacherPosition = teacherPosition;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getTeacherDesc() {
        return teacherDesc;
    }

    public void setTeacherDesc(String teacherDesc) {
        this.teacherDesc = teacherDesc;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
