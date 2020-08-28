package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.service.ErrorTechnologyDayExerciseSubmitService;
import com.yyhn.exam.vo.ErrorTechnologyDayExerciseSubmitVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ErrorTechnologyDayExerciseSubmitController {
    @Resource
    private ErrorTechnologyDayExerciseSubmitService errorTechnologyDayExerciseSubmitService;

    @GetMapping("/getErrorTechnologyDayExercise")
    public ResultMsg getErrorTechnologyDayExercise(Integer professionalId, Integer courseId, String titleName){
        List<ErrorTechnologyDayExerciseSubmitVO> list = errorTechnologyDayExerciseSubmitService.getErrorTechnologyDayExercise(professionalId, courseId, titleName);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @GetMapping("/getErrorTechnologyDayExerciseStudentByExercise")
    public ResultMsg getErrorTechnologyDayExerciseStudentByExercise(Integer exerciseId){
        List<ErrorTechnologyDayExerciseSubmitVO> list = errorTechnologyDayExerciseSubmitService.getTechnologyDayExerciseStudentByErrorId(exerciseId);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
