package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Professional;
import com.yyhn.exam.mapper.ProfessionalMapper;
import com.yyhn.exam.service.ProfessionalService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "professionalService")
public class ProfessionalServiceImpl implements ProfessionalService {

    @Resource
    ProfessionalMapper professionalMapper;

    @Override
    public void getProfessional(String pname,Page<List<Professional>> page) {

        Map<String ,Object> map = new HashMap<>();
        map.put("professionalName",pname);
        map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());

        List<Professional> professionalList = professionalMapper.getAllProfessional(map);
        int total = professionalMapper.getCount(map);
        page.setData(professionalList);
        page.setTotal(total);
    }

    @Override
    public List<Professional> getAllProfessional(String pname,int pageSize,int currentPage) {
        Map<String ,Object> map = new HashMap<>();
        map.put("professionalName",pname);
        map.put("startRow",(currentPage-1)*pageSize);
        map.put("pageSize",pageSize);

        List<Professional> professionalList = professionalMapper.getAllProfessional(map);
        return professionalList;
    }

    public List<Professional> getProfessionalNoPage(){
        List<Professional> professionalList = professionalMapper.getProfessionalNoPage();
        return professionalList;
    }

    @Override
    public int addProfessional(Professional professional) {
        int count = professionalMapper.addProfessional(professional);
        return count;
    }

    @Override
    public int updateProfessional(Professional professional) {
        int count = professionalMapper.updateProfessional(professional);
        return count;
    }

    @Override
    public int deleteProfessional(@Param("id") int id) {
        int count = professionalMapper.deleteProfessional(id);
        return count;
    }
}
