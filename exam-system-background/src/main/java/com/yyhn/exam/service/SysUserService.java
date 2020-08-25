package com.yyhn.exam.service;

import com.yyhn.exam.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface SysUserService {


    public Integer getUserIdByUserNameOrPassword(String login_Name,String login_password);
    public Integer getUserIdByUserNameAndPassword(String login_Name,String login_password);
    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    public int deleteSysUser(int id);

    /**
     * 批量删除
     * @param list
     * @return
     */
    public int deleteSysUsers(List<SysUser> list);

    /**
     * 添加用户
     * @param sysUser
     * @return
     */
    public int addSysUser(SysUser sysUser);

    /**
     * 修改用户
     * @param sysUser
     * @return
     */
    public int updateSysUser(SysUser sysUser);

    /**
     * 根据条件分页查询
     * @param department
     * @param position
     * @param page
     * @param pageSize
     * @return
     */
    public List<SysUser> getSysUserByPage(String department, String position, Integer page, Integer pageSize);

    public String login(String username , String pasword , HttpServletRequest request);
}
