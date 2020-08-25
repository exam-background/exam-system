package com.yyhn.exam.service;

import com.yyhn.exam.entity.TechnologyDayExerciseItem;

import java.util.List;

public interface AppTechnologyDayExerciseItemService {
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

    /**
     * 根据ID 获取每日一练备选选项信息
     * @param id
     * @return
     */
    public List<TechnologyDayExerciseItem> getTechnologyDayExerciseByExerciseId(int id);
}
