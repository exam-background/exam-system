package com.yyhn.exam.common;

import java.util.List;

public class Page<T> {

    private Integer curPage;

    /**
     * 总记录数 .
     */
    private Integer total;

    /**
     * 每页行数 .
     */
    private Integer pageSize;

    /**
     * 页面的总数  .
     */
    private Integer pageCount;

    /**
     * 结果集中数据的起始位置  .
     */
    private Integer beginPos;

    private T data;

    /**
     * List 集合.
     */
    private List<T> rows;


    public Page() {

    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCurPage() {
        return curPage;
    }

    public void setCurPage(Integer curPage) {
        this.curPage = curPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getBeginPos() {
        return beginPos;
    }

    public void setBeginPos(Integer beginPos) {
        this.beginPos = beginPos;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
