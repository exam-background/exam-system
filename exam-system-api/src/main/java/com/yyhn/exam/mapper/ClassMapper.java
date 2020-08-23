package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
import com.yyhn.exam.entity.Class;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ClassMapper{

    /**
     * 获取所有的班级信息，不分页显示
     * @return
     */
    public List<Class> getAllClassNoPage();
    /**
     * 根据条件获取班级信息
     * @return
     */
    public List<Class> getAllClass(Map<String,Object> map);


    /**
     * 获取记录数
     * @return
     */
    public int getCount(Map<String,Object> map);

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
     * 根据ID 删除班级信息
     * @return
     */
    public int deleteClass(int id);

    /**
     * 检查班级中是否存在学生
     * @param id
     * @return
     */
    public int checkClassInStudent(@Param("id") int id);
}
