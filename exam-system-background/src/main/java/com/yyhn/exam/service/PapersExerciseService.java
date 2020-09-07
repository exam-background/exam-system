package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersExercise;

import java.util.List;

public interface PapersExerciseService {
    /**
     * 根据题目id删除考试题目备选答案
     * @param id
     * @return
     */
    public int deletePapersExercise(Integer id) throws RuntimeException;

    /**
     * 添加考试题目备选答案
     * @param papersExercise
     * @return
     */
    public void insertPapersExercise(PapersExercise papersExercise) throws RuntimeException;

    /**
     * 根据题目id获取备选答案
     * @param id
     * @return
     */
    List<PapersExercise> getPapersExerciseByTitleId(Integer id);
}
