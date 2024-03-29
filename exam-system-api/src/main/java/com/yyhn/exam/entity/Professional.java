package com.yyhn.exam.entity;


import jdk.nashorn.internal.ir.annotations.Immutable;

import java.io.Serializable;


public class Professional implements Serializable {

    private Integer id;
    private String professionalName;
    private String professionalDesc;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfessionalName() {
        return professionalName;
    }

    public void setProfessionalName(String professionalName) {
        this.professionalName = professionalName;
    }

    public String getProfessionalDesc() {
        return professionalDesc;
    }

    public void setProfessionalDesc(String professionalDesc) {
        this.professionalDesc = professionalDesc;
    }

    public String toString(){
        return "ID : "+id +"\t  professionalName :"+professionalName+"\t professionalDesc :"+professionalDesc;
    }
}
