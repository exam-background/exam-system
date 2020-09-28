package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.mapper.TechnologyDayExerciseSubmitMapper;
import com.yyhn.exam.service.AppTechnologyDayExerciseSubmitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AppTechnologyDayExerciseSubmitServiceImpl implements AppTechnologyDayExerciseSubmitService {
    @Resource
    private TechnologyDayExerciseSubmitMapper technologyDayExerciseSubmitMapper;

    @Override
    public List<TechnologyDayExerciseSubmit> getTechnologyDayExerciseSubmitByUserId(Integer id) {
        return technologyDayExerciseSubmitMapper.getTechnologyDayExerciseSubmitByUserId(id);
    }

    @Override
    public int addTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit) {
        return technologyDayExerciseSubmitMapper.insert(technologyDayExerciseSubmit);
    }
    @Override
    public List<TechnologyDayExerciseSubmit> getTechnologyDayExerciseSubmitByRight(Integer id) {
        return technologyDayExerciseSubmitMapper.getTechnologyDayExerciseSubmitByRight(id);
    }

    @Override
    public List<TechnologyDayExerciseSubmit> getTechnologyDayExerciseSubmit(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("student_id", id);
        return technologyDayExerciseSubmitMapper.selectByMap(map);
    }
}
