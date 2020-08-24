package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.service.AppTechnologyDayExerciseService;
import com.yyhn.exam.service.TechnologyDayExerciseSubmitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/AppTechnologyDayExerciseController")
public class AppTechnologyDayExerciseController {
    @Resource
    private AppTechnologyDayExerciseService appTechnologyDayExerciseService;

    @RequestMapping("/getTechnologyDayExerciseSubmit")
    public ResultMsg getTechnologyDayExerciseSubmit(Integer id){
        List<TechnologyDayExercise> list = appTechnologyDayExerciseService.getTechnologyDayExerciseSubmit(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
