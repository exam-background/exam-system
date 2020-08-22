package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.mapper.TechnologyDayExerciseMapper;
import com.yyhn.exam.service.TechnologyDayExerciseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        if (page != null){
            map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
            map.put("pageSize",page.getPageSize());
        }
        List<TechnologyDayExercise> technologyDayExerciseList = technologyDayExerciseMapper.getAllTechnologyDayExercise(map);
        int total = technologyDayExerciseMapper.getCount(map);
        page.setData(technologyDayExerciseList);
        page.setTotal(total);
    }

    @Override
    public List<TechnologyDayExercise> getTechnologyDayExercise(String title, String types, Integer profesionalId, Integer courseId) {
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("title",title);
        map.put("types",types);
        map.put("professionId",profesionalId);
        map.put("courseId",courseId);
        return technologyDayExerciseMapper.getAllTechnologyDayExercise(map);
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
    public int deleteTechnologyDayExercises(List<TechnologyDayExercise> list) {
        List<Integer> lists = new ArrayList<Integer>();
        for(TechnologyDayExercise technologyDayExercise : list){
            lists.add(technologyDayExercise.getId());
        }
        return technologyDayExerciseMapper.deleteTechnologyDayExercises(lists);
    }

    @Override
    public int insertTechnologyDayExercise(TechnologyDayExercise technologyDayExercise) {
        return technologyDayExerciseMapper.addTechnologyDayExercise(technologyDayExercise);
    }

    @Override
    public TechnologyDayExercise getTechnologyDayExerciseById(Integer id) {
        TechnologyDayExercise technologyDayExercise = technologyDayExerciseMapper.getTechnologyDayExerciseById(id);
        return technologyDayExercise;
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public int getTechnologyDayExerciseByCourse(Integer professionalId, Integer courseId, Integer a, Integer b) throws RuntimeException{
        int sum = technologyDayExerciseMapper.getTechnologyDayExerciseByCourse(professionalId, courseId);
        if((a/b)>sum){
            throw new RuntimeException("当前科目题目不足"+a/b+"个");
        }
        return sum;
    }

    @Override
    public TechnologyDayExercise getTechnologyDayExerciseBypProfessionalCourse(Integer professionalId, Integer courseId, Integer page) {
        return technologyDayExerciseMapper.getTechnologyDayExerciseBypProfessionalCourse(professionalId, courseId, page);
    }

    @Override
    public List<TechnologyDayExercise> getTechnologyDayExerciseByProfessionalId(Integer professionalId) {
        if(professionalId != 0) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("Professional_id", professionalId);
            return technologyDayExerciseMapper.getAllTechnologyDayExercise(map);
        }else{
            return technologyDayExerciseMapper.getAllTechnologyDayExercise(null);
        }
    }
}
