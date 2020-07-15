package com.yyhn.exam.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.util.List;

@TableName("exam_sys_user")
public class SysUser{
    /**
     * 主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    /**
     * 登录名
     */

    private String login_name;
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
    private String mobile_phone;
    /**
     * 创建时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JSONField(format = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date create_time;
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

    public String getLogin_name() {
        return login_name;
    }

    public void setLogin_name(String login_name) {
        this.login_name = login_name;
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

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public SysUser(int id, String login_name, String real_name, String login_password, String department, String position, String mobile_phone, Date create_time, String remark) {
        this.id = id;
        this.login_name = login_name;
        this.real_name = real_name;
        this.login_password = login_password;
        this.department = department;
        this.position = position;
        this.mobile_phone = mobile_phone;
        this.create_time = create_time;
        this.remark = remark;
    }

    public SysUser() {
    }
}
