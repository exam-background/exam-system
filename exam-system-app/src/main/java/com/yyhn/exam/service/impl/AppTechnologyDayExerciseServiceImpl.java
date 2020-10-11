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
        List<TechnologyDayExercise> list = appTechnologyDayExerciseMapper.getTechnologyDayExerciseSubmit(id, studentid, (page.getCurPage()-1)*page.getPageSize(), page.getPageSize());
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
