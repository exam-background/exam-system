package com.yyhn.exam.service.impl;

import com.yyhn.exam.mapper.StudentCuoTiMapper;
import com.yyhn.exam.service.StudentCuoTiService;
import com.yyhn.exam.vo.TechnologyDayExerciseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentCuoTiServiceImpl implements StudentCuoTiService {
    @Resource
    private StudentCuoTiMapper mapper;
    @Override
    public List<TechnologyDayExerciseVO> getJianDa(int studentId) {
        return mapper.getJianDa(studentId);
    }

    @Override
    public List<TechnologyDayExerciseVO> getXuanZe(int studentId) {
        return mapper.getXuanZe(studentId);
    }
}
