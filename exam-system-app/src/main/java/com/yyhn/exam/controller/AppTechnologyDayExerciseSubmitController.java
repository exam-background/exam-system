package com.yyhn.exam.controller;

import com.yyhn.exam.service.TechnologyDayExerciseSubmitService;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/app/TechnologyDayExerciseSubmitController")
public class AppTechnologyDayExerciseSubmitController {
    @Resource
    private TechnologyDayExerciseSubmitService technologyDayExerciseSubmitService;

    @RequestMapping("/addTechnologyDayExerciseSubmit")
    public ResultMsg addTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit){
        if(technologyDayExerciseSubmitService.addTechnologyDayExerciseSubmit(technologyDayExerciseSubmit) > 0){
            return ResultMsg.BY_SUCCESS("添加成功", null);
        }else{
            return ResultMsg.BY_FAIL("添加失败");
        }
    }
}
