package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.JobDayExerciseSubmit;
import com.yyhn.exam.service.JobDayExerciseSubmitService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/app/JobDayExerciesSubmitController")
public class AppJobDayExerciesSubmitController {
    @Resource
    private JobDayExerciseSubmitService jobDayExerciseSubmitService;

    @RequestMapping("/addJobDayExerciseSubmit")
    public ResultMsg addJobDayExerciseSubmit(JobDayExerciseSubmit jobDayExerciseSubmit){
        if(jobDayExerciseSubmitService.addJobDayExerciseSubmit(jobDayExerciseSubmit) > 0){
            return ResultMsg.BY_SUCCESS("添加成功", null);
        }else{
            return ResultMsg.BY_FAIL("添加失败");
        }
    }
}
