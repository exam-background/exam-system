package com.yyhn.exam.vo;

import java.io.Serializable;

public class JobExamStudySearchVO implements Serializable {

    private String title;

    private Integer proName;

    private Integer csName;

    private Integer pageSize=5;

    private Integer currentPage=1;


    @Override
    public String toString() {
        return "JobExamStudySearchVO{" +
                "title='" + title + '\'' +
                ", proName=" + proName +
                ", csName=" + csName +
                ", pageSize=" + pageSize +
                ", currentPage=" + currentPage +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getProName() {
        return proName;
    }

    public void setProName(Integer proName) {
        this.proName = proName;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public Integer getCsName() {
        return csName;
    }

    public void setCsName(Integer csName) {
        this.csName = csName;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
