package com.yyhn.exam.mapper;

import com.yyhn.exam.entity.Professional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface ProfessionalMapper {

    /**
     * 带条件获取所有的专业信息
     * @return
     */
    public List<Professional> getAllProfessional(Map<String,Object> param);

    /**
     * 获取所有的专业信息
     * @return
     */
    public List<Professional> getProfessionalNoPage();


    /**
     * 根据条件获取总记录数
     * @param param
     * @return
     */
    public int getCount(Map<String,Object> param);

    /**
     * 增加专业课程信息
     * @param professional
     * @return
     */
    public int addProfessional(Professional professional);

    /**
     * 修改专业课程信息
     * @param professional
     * @return
     */
    public int updateProfessional(Professional professional);


    /**
     * 删除专业课程信息
     * @param id   专业课程ID
     * @return
     */
    public int deleteProfessional(@Param(value = "id") int id);

}
