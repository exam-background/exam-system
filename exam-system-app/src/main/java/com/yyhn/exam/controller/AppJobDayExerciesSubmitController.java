package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.JobDayExerciseSubmit;
import com.yyhn.exam.service.AppJobDayExerciseSubmitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/JobDayExerciesSubmitController")
public class AppJobDayExerciesSubmitController {
    @Resource
    private AppJobDayExerciseSubmitService appJobDayExerciseSubmitService;

    @PostMapping("/addJobDayExerciseSubmit")
    public ResultMsg addJobDayExerciseSubmit(JobDayExerciseSubmit jobDayExerciseSubmit){
        if(appJobDayExerciseSubmitService.addJobDayExerciseSubmit(jobDayExerciseSubmit) > 0){
            return ResultMsg.BY_SUCCESS("添加成功", null);
        }else{
            return ResultMsg.BY_FAIL("添加失败");
        }
    }

    @GetMapping("/getJobDayExerciseSubmitByUserId")
    public ResultMsg getJobDayExerciseSubmitByUserId(Integer id){
        List<JobDayExerciseSubmit> list = appJobDayExerciseSubmitService.getJobDayExerciseSubmitByUserId(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @GetMapping("/getJobDayExerciseSubmitByRight")
    public ResultMsg getJobDayExerciseSubmitByRight(Integer id){
        List<JobDayExerciseSubmit> list = appJobDayExerciseSubmitService.getJobDayExerciseSubmitByRight(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
