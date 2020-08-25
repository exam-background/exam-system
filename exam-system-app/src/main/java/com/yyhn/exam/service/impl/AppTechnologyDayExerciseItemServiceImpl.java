package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.TechnologyDayExerciseItem;
import com.yyhn.exam.mapper.TechnologyDayExerciseItemMapper;
import com.yyhn.exam.service.AppTechnologyDayExerciseItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppTechnologyDayExerciseItemServiceImpl implements AppTechnologyDayExerciseItemService {
    @Resource
    private TechnologyDayExerciseItemMapper technologyDayExerciseItemMapper;

    @Override
    public int addTechnologyDayExerciseItem(TechnologyDayExerciseItem technologyDayExerciseItem) {
        return technologyDayExerciseItemMapper.addTechnologyDayExerciseItem(technologyDayExerciseItem);
    }

    @Override
    public int updateTechnologyDayExerciseItem(TechnologyDayExerciseItem technologyDayExerciseItem) {
        return technologyDayExerciseItemMapper.updateTechnologyDayExerciseItem(technologyDayExerciseItem);
    }

    @Override
    public List<TechnologyDayExerciseItem> getTechnologyDayExerciseByExerciseId(int id) {
        return technologyDayExerciseItemMapper.getTechnologyDayExerciseByExerciseId(id);
    }
}
