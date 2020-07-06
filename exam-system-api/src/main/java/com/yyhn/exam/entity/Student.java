package com.yyhn.exam.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Student {
    private Integer id;
    private String stuName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date openClassTime;
    private Class clazz= new Class();
    private Professional professional = new Professional();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Date getOpenClassTime() {
        return openClassTime;
    }

    public void setOpenClassTime(Date openClassTime) {
        this.openClassTime = openClassTime;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }
}
