package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersExercise;
import com.yyhn.exam.mapper.PapersExerciseMapper;
import com.yyhn.exam.service.PapersExerciseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PapersExerciseServiceImpl implements PapersExerciseService {
    @Resource
    private PapersExerciseMapper papersExerciseMapper;

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public void deletePapersExercise(Integer id) throws RuntimeException{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title_id", id);
        if(papersExerciseMapper.deleteByMap(map) < 0){
            throw new RuntimeException("题目备选答案删除失败");
        }
    }

    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public void insertPapersExercise(PapersExercise papersExercise) throws RuntimeException{
        if(papersExerciseMapper.insert(papersExercise) < 0){
            throw new RuntimeException("题目备选答案删除失败");
        }
        System.out.println("题目备选答案增加完成");
    }

    @Override
    public List<PapersExercise> getPapersExerciseByTitleId(Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("title_id", id);
        return papersExerciseMapper.selectByMap(map);
    }
}
