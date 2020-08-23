package com.yyhn.exam.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.yyhn.exam.mapper.SysRoleMapper;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
@Data
public class SysUserDetail implements UserDetails {
    private SysUser sysUser;
    private List<SysMenu> permissions;
    /**
     * 主键
     */
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

    public SysUserDetail(SysUser sysUser, List<SysMenu> permissions) {
        this.sysUser= sysUser;
        this.permissions = permissions;
        System.out.println(permissions.toString()+"******************************");
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
      if(null != roles){
          for(SysRole role : roles){
              System.out.println("=================================="+role.getRoleName());
              authorities.add(new SimpleGrantedAuthority(role.getRoleName()));

          }
      }
        return authorities;
    }

    @Override
    public String getPassword() {
        return this.login_password;
    }

    @Override
    public String getUsername() {
        return this.login_name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public SysUser getSysUser() {
        return sysUser;
    }

    public void setSysUser(SysUser sysUser) {
        this.sysUser = sysUser;
    }
}
