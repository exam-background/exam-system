package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.TechnologyDayExerciseItem;
import com.yyhn.exam.mapper.TechnologyDayExerciseItemMapper;
import com.yyhn.exam.service.TechnologyDayExerciseItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TechnologyDayExerciseItemServiceImpl implements TechnologyDayExerciseItemService {
    @Resource
    private TechnologyDayExerciseItemMapper technologyDayExerciseItemMapper;

    @Override
    public int addTechnologyDayExerciseItem(TechnologyDayExerciseItem technologyDayExerciseItem) {
        return technologyDayExerciseItemMapper.addTechnologyDayExerciseItem(technologyDayExerciseItem);
    }
}
