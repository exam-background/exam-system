package com.yyhn.exam.service;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.Page;

import com.yyhn.exam.entity.Class;

import java.util.List;

/**
 * 班级业务逻辑类
 */
public interface ClassService {

    /**
     * 获取所有的班级信息，不分页显示
     * @return
     */
    public List<Class> getAllClassNoPage();

    /**
     * 分页
     * @param grade  学期
     * @param classTeacherId  班主任ID
     * @param professionalTeacherId  教员ID
     * @param page
     */
    public void getAllClass(String grade,Integer classTeacherId,Integer professionalTeacherId, Page<List<Class>> page);

    /**
     * 添加班级信息
     * @return
     */
    public int addClass(Class clazz);

    /**
     * 修改班级信息
     * @return
     */
    public int updateClass(Class clazz);

    /**
     * 删除班级信息
     * @return
     */
    public Dto<Object> deleteClass(int id);
}
