package com.yyhn.exam.common;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SysUserLoginParam {
    @ApiModelProperty(value = "用户名", required = true)
    private String username;
    @ApiModelProperty(value = "密码", required = true)
    private String password;
}
