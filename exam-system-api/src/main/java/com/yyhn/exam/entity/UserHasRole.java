package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;


@TableName("exam_user_role")
public class UserHasRole {
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    private Integer roleId;
}
