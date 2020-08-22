package com.yyhn.exam.service;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.entity.TechnologyDayExercise;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TechnologyDayExerciseService {

    /**
     * 根据条件获取就业示范学习信息
     * @return
     */
    public void getAllTechnologyDayExercise(String title,String types,Integer profesionalId,Integer courseId, Page<List<TechnologyDayExercise>> page);

    /**
     * 根据条件获取就业示范学习信息
     * @return
     */
    public List<TechnologyDayExercise> getTechnologyDayExercise(String title,String types,Integer profesionalId,Integer courseId);

    /**
     * 增加技术每日一练
     * @return
     */
    public int addTechnologyDayExercise(TechnologyDayExercise technologyDayExercise);


    /**
     * 修改技术每日一练
     * @return
     */
    public int updateTechnologyDayExercise(TechnologyDayExercise technologyDayExercise);


    /**
     * 删除技术每日一练信息
     * @return
     */
    public int deleteTechnologyDayExercise( int id);


    public int deleteTechnologyDayExercises(List<TechnologyDayExercise> list);
    /**
     * 新增每日一练
     * @param technologyDayExercise
     * @return
     */
    public int insertTechnologyDayExercise(TechnologyDayExercise technologyDayExercise);

    /**
     * 根据ID 获取技术每日一练
     * @param id
     * @return
     */
    public TechnologyDayExercise getTechnologyDayExerciseById(Integer id);

    /**
     * 获取题库中该科目的总数量
     * @param professionalId
     * @param courseId
     * @return
     */
    public int getTechnologyDayExerciseByCourse(Integer professionalId, Integer courseId, Integer a, Integer b) throws RuntimeException;

    /**
     * 根据科目拿到到随机的题目
     * @param professionalId
     * @param courseId
     * @param page
     * @return
     */
    public TechnologyDayExercise getTechnologyDayExerciseBypProfessionalCourse(Integer professionalId, Integer courseId, Integer page);

    /**
     * 根据科目id查询所有题目
     * @param professionalId
     * @return
     */
    public List<TechnologyDayExercise> getTechnologyDayExerciseByProfessionalId(Integer professionalId);
}
