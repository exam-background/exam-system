package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersCourse;
import com.yyhn.exam.mapper.PapersCourseMapper;
import com.yyhn.exam.service.PapersCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class PapersCourseServiceImpl implements PapersCourseService {
    @Resource
    private PapersCourseMapper papersCourseMapper;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public int deletePapersCourse(Integer id) throws RuntimeException{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("papers_id", id);
        return papersCourseMapper.deleteByMap(map);
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public void insertPapersCourse(PapersCourse papersCourse) throws RuntimeException{
        if(papersCourseMapper.insert(papersCourse) <= 0){
            throw new RuntimeException("试卷，科目关系表新增失败");
        }
        System.out.println("试卷，科目关系表增加完成");
    }
}
