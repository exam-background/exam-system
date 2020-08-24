package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.service.AppJobDayExerciseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/AppJobDayExerciseController")
public class AppJobDayExerciseController {
    @Resource
    private AppJobDayExerciseService appJobDayExerciseService;

    @RequestMapping("/getJobDayExerciseByProfessid")
    public ResultMsg getJobDayExerciseByProfessid(Integer id){
        List<JobDayExercise> list = appJobDayExerciseService.getJobDayExerciseByProfessid(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
