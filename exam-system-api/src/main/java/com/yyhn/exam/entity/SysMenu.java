package com.yyhn.exam.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Data
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 6623321308563192765L;
    /**
     *
     */
    private Long id;
    /**
     * 父级权限id
     */
    @ApiModelProperty(value = "父级权限id")
    private Long parent_id;
    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String name;
    /**
     * 权限值
     */
    @ApiModelProperty(value = "权限值")
    private String value;
    /**
     * 图标
     */
    @ApiModelProperty(value = "图标")
    private String icon;
    /**
     * 权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）
     */
    @ApiModelProperty(value = "权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）")
    private String type;
    /**
     * 前端资源路径
     */
    @ApiModelProperty(value = "前端资源路径")
    private String uri;
    /**
     * 启用状态；0->禁用；1->启用
     */
    @ApiModelProperty(value = "启用状态；0->禁用；1->启用")
    private String state;
    /**
     * 路由地址
     */
    @ApiModelProperty(value = "路由地址")
    private String alias;

    private String discription;

    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;

    private String power;
    private List<?> list;

    private List<SysMenu> children = new ArrayList<>();
}
