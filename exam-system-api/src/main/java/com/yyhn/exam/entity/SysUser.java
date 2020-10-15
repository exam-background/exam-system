package com.yyhn.exam.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@TableName("exam_sys_user")
public class SysUser implements Serializable {
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    /**
     * 登录名
     */

    private String loginName;
    /**
     * 真实名称
     */
    private String real_name;
    /**
     * 登录密码
     */
    private String login_password;
    /**
     * 所属部门
     */
    private String department;
    /**
     * 职位
     */
    private String position;
    /**
     * 手机号码
     */
    private String mobilePhone;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    /**
     * 备注信息
     */
    private String remark;

    /**
     * 一个用户拥有多个角色
     */

    @TableField(exist = false)
    private List<SysRole> roles;

    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReal_name() {
        return real_name;
    }

    public void setReal_name(String real_name) {
        this.real_name = real_name;
    }

    public String getLogin_password() {
        return login_password;
    }

    public void setLogin_password(String login_password) {
        this.login_password = login_password;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SysUser(int id, String loginName, String real_name, String login_password, String department, String position, String mobilePhone, Date createTime, String remark) {
        this.id = id;
        this.loginName = loginName;
        this.real_name = real_name;
        this.login_password = login_password;
        this.department = department;
        this.position = position;
        this.mobilePhone = mobilePhone;
        this.createTime = createTime;
        this.remark = remark;
    }

    public SysUser() {
    }
}
