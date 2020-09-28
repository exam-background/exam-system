package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.mapper.AppTechnologyDayExerciseMapper;
import com.yyhn.exam.service.AppTechnologyDayExerciseService;
import com.yyhn.exam.service.AppTechnologyDayExerciseSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AppTechnologyDayExerciseServiceImpl implements AppTechnologyDayExerciseService {
    @Resource
    private AppTechnologyDayExerciseMapper appTechnologyDayExerciseMapper;
    @Resource
    private AppTechnologyDayExerciseSubmitService appTechnologyDayExerciseSubmitService;

    @Override
    public void getTechnologyDayExerciseSubmit(Integer id, Page<List<TechnologyDayExercise>> page, Integer studentid) {
        List<TechnologyDayExercise> lists = appTechnologyDayExerciseMapper.getTechnologyDayExerciseSubmit(id, (page.getCurPage()-1)*page.getPageSize(), page.getPageSize());
        // 将做过的题排除在外
        List<TechnologyDayExercise> list = new ArrayList<TechnologyDayExercise>();
        // 查询做过的题目
        List<TechnologyDayExerciseSubmit> technologyDayExerciseSubmitlist = appTechnologyDayExerciseSubmitService.getTechnologyDayExerciseSubmit(studentid);
        for(TechnologyDayExercise technologyDayExercise : lists){
            int a = 0;
            for(TechnologyDayExerciseSubmit technologyDayExerciseSubmit:technologyDayExerciseSubmitlist){
                if(technologyDayExercise.getId() == technologyDayExerciseSubmit.getExerciseId()){
                    a = 1;
                    break;
                }
            }
            if(a == 0){
                list.add(technologyDayExercise);
            }
        }
        int total = appTechnologyDayExerciseMapper.getTechnologyDayExerciseSubmitCount(id);
        page.setData(list);
        page.setTotal(total);
        System.out.println(page);
    }

    @Override
    public TechnologyDayExercise getTechnologyDayExerciseById(Integer id) {
        return appTechnologyDayExerciseMapper.selectById(id);
    }
}
