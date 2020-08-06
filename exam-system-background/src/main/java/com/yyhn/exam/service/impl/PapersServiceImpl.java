package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.Papers;
import com.yyhn.exam.mapper.PapersMapper;
import com.yyhn.exam.service.PapersService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PapersServiceImpl implements PapersService {
    @Resource
    private PapersMapper papersMapper;

    @Override
    public List<Papers> getPapersAll(Papers papers) {
        return papersMapper.getPapersAll(papers);
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public void deletePapers(Integer id) throws RuntimeException{
        if(papersMapper.deleteById(id) < 0){
            throw new RuntimeException("试卷删除失败");
        }
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public void insertPapers(Papers papers) throws RuntimeException{
        if(papersMapper.insert(papers) < 0){
            throw new RuntimeException("试卷增加失败");
        }
        System.out.println("试卷增加完成");
    }

    @Override
    public int publishPapers(Integer id) {
        Papers papers = new Papers();
        papers.setIspublish(1);
        papers.setId(id);
        return papersMapper.updateById(papers);
    }
}
