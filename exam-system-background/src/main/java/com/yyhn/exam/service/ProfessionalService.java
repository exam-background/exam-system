package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Professional;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProfessionalService {

    /**
     * 分页
     * @param pname
     * @param page
     */
    public void getProfessional(String pname,Page<List<Professional>> page);

    /**
     * 获取所有的专业信息，不分页处理
     * @return
     */
    public List<Professional> getProfessionalNoPage();

    /**
     * 获取所有的专业信息
     * @return
     */
    public List<Professional> getAllProfessional(String pname,int pageSize,int currentPage);

    /**
     * 添加专业
     * @param professional
     * @return
     */
    public int addProfessional(Professional professional);

    /**
     * 修改专业信息
     * @param professional
     * @return
     */
    public int updateProfessional(Professional professional);

    /**
     * 删除专业信息
     * @param id
     * @return
     */
    public int deleteProfessional(int id);
}
