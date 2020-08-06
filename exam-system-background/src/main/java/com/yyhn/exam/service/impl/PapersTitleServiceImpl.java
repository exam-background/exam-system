package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.mapper.PapersTitleMapper;
import com.yyhn.exam.service.PapersTitleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PapersTitleServiceImpl implements PapersTitleService {
    @Resource
    private PapersTitleMapper papersTitleMapper;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public void deletePapersTitle(Integer id)  throws RuntimeException{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("papers_id", id);
        if(papersTitleMapper.deleteByMap(map) < 0){
            throw new RuntimeException("试卷题目删除失败");
        }
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public void insertPapersTitle(PapersTitle papersTitle)  throws RuntimeException{
        if(papersTitleMapper.insert(papersTitle) <= 0){
            throw new RuntimeException("试卷题目新增失败");
        }
        System.out.println("试卷题目增加完成");
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<PapersTitle> getPapersTitleByPapersId(Integer id)  throws RuntimeException{
        List<PapersTitle> papersTitleList = papersTitleMapper.getPapersTitleByPapersId(id);
        if(papersTitleList.size() < 0){
            throw new RuntimeException("试卷题目查询失败");
        }
        return papersTitleList;
    }
}
