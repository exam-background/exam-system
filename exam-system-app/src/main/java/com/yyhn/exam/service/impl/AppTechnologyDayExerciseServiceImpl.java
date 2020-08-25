package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.mapper.AppTechnologyDayExerciseMapper;
import com.yyhn.exam.service.AppTechnologyDayExerciseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppTechnologyDayExerciseServiceImpl implements AppTechnologyDayExerciseService {
    @Resource
    private AppTechnologyDayExerciseMapper appTechnologyDayExerciseMapper;

    @Override
    public void getTechnologyDayExerciseSubmit(Integer id, Page<List<TechnologyDayExercise>> page) {
        List<TechnologyDayExercise> list = appTechnologyDayExerciseMapper.getTechnologyDayExerciseSubmit(id, (page.getCurPage()-1)*page.getPageSize(), page.getPageSize());
        int total = appTechnologyDayExerciseMapper.getTechnologyDayExerciseSubmitCount(id);
        page.setData(list);
        page.setTotal(total);
        System.out.println(page);
    }
}
