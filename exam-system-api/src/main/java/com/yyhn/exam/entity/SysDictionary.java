package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import io.swagger.models.auth.In;

import java.util.Date;

@TableName(value = "exam_sys_dictionary")
public class SysDictionary {
    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 字典名称
     */
    private String dictionaryName;
    /**
     * 字典类型
     */
    private String dictionaryType;
    /**
     * 状态
     */
    private String dictionaryState;
    /**
     * 备注
     */
    private String dictionaryRemark;
    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDictionaryName() {
        return dictionaryName;
    }

    public void setDictionaryName(String dictionaryName) {
        this.dictionaryName = dictionaryName;
    }

    public String getDictionaryType() {
        return dictionaryType;
    }

    public void setDictionaryType(String dictionaryType) {
        this.dictionaryType = dictionaryType;
    }

    public String getDictionaryState() {
        return dictionaryState;
    }

    public void setDictionaryState(String dictionaryState) {
        this.dictionaryState = dictionaryState;
    }

    public String getDictionaryRemark() {
        return dictionaryRemark;
    }

    public void setDictionaryRemark(String dictionaryRemark) {
        this.dictionaryRemark = dictionaryRemark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public SysDictionary(int id, String dictionaryName, String dictionaryType, String dictionaryState, String dictionaryRemark, Date createTime) {
        this.id = id;
        this.dictionaryName = dictionaryName;
        this.dictionaryType = dictionaryType;
        this.dictionaryState = dictionaryState;
        this.dictionaryRemark = dictionaryRemark;
        this.createTime = createTime;
    }

    public SysDictionary() {
    }
}
