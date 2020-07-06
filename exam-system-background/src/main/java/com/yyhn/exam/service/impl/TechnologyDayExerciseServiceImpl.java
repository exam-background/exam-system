package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.mapper.TechnologyDayExerciseMapper;
import com.yyhn.exam.service.TechnologyDayExerciseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TechnologyDayExerciseServiceImpl implements TechnologyDayExerciseService {
    @Resource
    TechnologyDayExerciseMapper technologyDayExerciseMapper;

    @Override
    public void getAllTechnologyDayExercise(String title, String types, Integer profesionalId, Integer courseId, Page<List<TechnologyDayExercise>> page) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title",title);
        map.put("types",types);
        map.put("professionId",profesionalId);
        map.put("courseId",courseId);
        map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());
        List<TechnologyDayExercise> technologyDayExerciseList = technologyDayExerciseMapper.getAllTechnologyDayExercise(map);
        int total = technologyDayExerciseMapper.getCount(map);
        page.setData(technologyDayExerciseList);
        page.setTotal(total);
    }

    @Override
    public int addTechnologyDayExercise(TechnologyDayExercise technologyDayExercise) {
        int count = technologyDayExerciseMapper.addTechnologyDayExercise(technologyDayExercise);
        System.out.println("technologyDayExercise.getId() : " + technologyDayExercise.getId());
        return count;
    }

    @Override
    public int updateTechnologyDayExercise(TechnologyDayExercise technologyDayExercise) {
        int count = technologyDayExerciseMapper.updateTechnologyDayExercise(technologyDayExercise);
        return count;
    }

    @Override
    public int deleteTechnologyDayExercise(int id) {
        int count = technologyDayExerciseMapper.deleteTechnologyDayExercise(id);
        return count;
    }

    @Override
    public TechnologyDayExercise getTechnologyDayExerciseById(int id) {
        TechnologyDayExercise technologyDayExercise = technologyDayExerciseMapper.getTechnologyDayExerciseById(id);
        return technologyDayExercise;
    }
}
