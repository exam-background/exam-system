package com.yyhn.exam.service;

import com.yyhn.exam.entity.TechnologyDayExerciseItem;

public interface TechnologyDayExerciseItemService {
    /**
     * 添加选择题
     * @param technologyDayExerciseItem
     * @return
     */
    public int addTechnologyDayExerciseItem(TechnologyDayExerciseItem technologyDayExerciseItem);

    /**
     * 修改选择题
     * @param technologyDayExerciseItem
     * @return
     */
    public int updateTechnologyDayExerciseItem(TechnologyDayExerciseItem technologyDayExerciseItem);
}
