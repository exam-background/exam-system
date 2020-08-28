package com.yyhn.exam.service.impl;

import com.yyhn.exam.mapper.ErrorTechnologyDayExerciseSubmitMapper;
import com.yyhn.exam.mapper.TechnologyDayExerciseSubmitMapper;
import com.yyhn.exam.service.ErrorTechnologyDayExerciseSubmitService;
import com.yyhn.exam.vo.ErrorTechnologyDayExerciseSubmitVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class ErrorTechnologyDayExerciseSubmitServiceImpl implements ErrorTechnologyDayExerciseSubmitService {
    @Resource
    private ErrorTechnologyDayExerciseSubmitMapper errorTechnologyDayExerciseSubmitMapper;

    @Override
    public List<ErrorTechnologyDayExerciseSubmitVO> getErrorTechnologyDayExercise(Integer professionalId, Integer courseId, String titleName) {
        //查询所有题目
        List<ErrorTechnologyDayExerciseSubmitVO> errorTechnologyDayExerciseSubmitVOList = errorTechnologyDayExerciseSubmitMapper.getErrorTechnologyDayExercise(professionalId, courseId, titleName);
        List<ErrorTechnologyDayExerciseSubmitVO> list = new ArrayList<ErrorTechnologyDayExerciseSubmitVO>();
        //遍历题目信息，获取错误百分比
        for(ErrorTechnologyDayExerciseSubmitVO errorTechnologyDayExerciseSubmitVO : errorTechnologyDayExerciseSubmitVOList){
            errorTechnologyDayExerciseSubmitVO.setErrorExerciseCount(errorTechnologyDayExerciseSubmitMapper.getErrorTechnologyDayExerciseCount(errorTechnologyDayExerciseSubmitVO.getTechnologyDayExercise().getId()));
            errorTechnologyDayExerciseSubmitVO.setExerciseCount(errorTechnologyDayExerciseSubmitMapper.getTechnologyDayExerciseCount(errorTechnologyDayExerciseSubmitVO.getTechnologyDayExercise().getId()));
            Double percent = ((errorTechnologyDayExerciseSubmitVO.getErrorExerciseCount()*1.0)/(errorTechnologyDayExerciseSubmitVO.getExerciseCount()*1.0))*100.00;
            errorTechnologyDayExerciseSubmitVO.setExercisePercent(percent+"%");
            list.add(errorTechnologyDayExerciseSubmitVO);
        }
        return list;
    }

    @Override
    public List<ErrorTechnologyDayExerciseSubmitVO> getTechnologyDayExerciseStudentByErrorId(Integer id) {
        return errorTechnologyDayExerciseSubmitMapper.getTechnologyDayExerciseStudentByErrorId(id);
    }
}
