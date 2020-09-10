package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.Papers;
import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.mapper.AppPapersMapper;
import com.yyhn.exam.service.AppPapersExerciseService;
import com.yyhn.exam.service.AppPapersService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import com.yyhn.exam.service.AppPapersService;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppPapersServiceImpl implements AppPapersService {
    @Resource
    private AppPapersMapper appPapersMapper;
    @Resource
    private AppPapersExerciseService appPapersExerciseService;

    @Override
    public List<Papers> getPapersByUserIdAndtype(Integer userId, Integer type) {
        List<Papers> listAll = appPapersMapper.getPapersByUserIdAndtype(userId, type);
        List<Papers> list = new ArrayList<Papers>();
        for (Papers papers : listAll){
            if(papers.getType() == 0){
                papers.setTypeName("就业训练");
            }
            list.add(papers);
        }
        return list;
    }

    @Override
    public List<Papers> getPapersByUserIdAndtypeFinish(Integer userId, Integer type) {
        List<Papers> listAll = appPapersMapper.getPapersByUserIdAndtypeFinish(userId, type);
        List<Papers> list = new ArrayList<Papers>();
        for (Papers papers : listAll){
            if(papers.getType() == 0){
                papers.setTypeName("就业训练");
            }
            list.add(papers);
        }
        return list;
    }

    @Override
    public Papers getPapersById(Integer id) {
        Papers papersa = appPapersMapper.getPapersById(id);
        for(PapersTitle papersTitle: papersa.getPapersTitleList()){
            if(papersTitle.getType() == 2){
                papersTitle.setPapersExercises(appPapersExerciseService.getPapersExerciseByTitleId(papersTitle.getId()));
            }
        }
        return papersa;
    }

    @Override
    public Papers getPapersByIdStudent(Integer id) {
        Papers papersa = appPapersMapper.getPapersByIdStudent(id);
        for(PapersTitle papersTitle: papersa.getPapersTitleList()){
            if(papersTitle.getType() == 2){
                papersTitle.setPapersExercises(appPapersExerciseService.getPapersExerciseByTitleId(papersTitle.getId()));
            }
        }
        return papersa;
    }

}
