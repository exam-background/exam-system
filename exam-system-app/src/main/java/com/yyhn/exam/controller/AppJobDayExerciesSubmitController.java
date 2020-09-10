package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.Levenshtein;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.JobDayExerciseSubmit;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.service.AppJobDayExerciseService;
import com.yyhn.exam.service.AppJobDayExerciseSubmitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/JobDayExerciesSubmitController")
@Api( value = "针对手机端就业每日一练做题记录进行维护",description = "手机端就业每日一练做题记录控制器类")
public class AppJobDayExerciesSubmitController {
    @Resource
    private AppJobDayExerciseSubmitService appJobDayExerciseSubmitService;
    @Resource
    private AppJobDayExerciseService appJobDayExerciseService;

    @ApiOperation(value = "手机端每日一练增加做题记录", httpMethod = "POST",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "每日一练增加做题记录")
    @PostMapping("/addJobDayExerciseSubmit")
    public ResultMsg addJobDayExerciseSubmit(JobDayExerciseSubmit jobDayExerciseSubmit){
        // 根据题目id拿到正确答案
        JobDayExercise jobDayExercise = appJobDayExerciseService.getJobDayExerciseById(jobDayExerciseSubmit.getExerciseId());
        // 判断题目是否正确
        float leven = Levenshtein.getSimilarityRatio(jobDayExercise.getAnswer(), jobDayExerciseSubmit.getSubmitAnswer());
        //是否正确
        int right = 0;
        // 如果当前相似度大于0.9则为正确
        if(leven >= 0.8){
            right = 1;
        }
        jobDayExerciseSubmit.setRight(right);
        if(appJobDayExerciseSubmitService.addJobDayExerciseSubmit(jobDayExerciseSubmit) > 0){
            return ResultMsg.BY_SUCCESS("添加成功", null);
        }else{
            return ResultMsg.BY_FAIL("添加失败");
        }
    }

    @ApiOperation(value = "手机端每日一练根据学生id查询每日一练做题信息", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "练根据学生id查询每日一练做题信息")
    @GetMapping("/getJobDayExerciseSubmitByUserId")
    public ResultMsg getJobDayExerciseSubmitByUserId(Integer id){
        List<JobDayExerciseSubmit> list = appJobDayExerciseSubmitService.getJobDayExerciseSubmitByUserId(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @ApiOperation(value = "手机端每日一练根据学生id查询每日一练错题信息", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "练根据学生id查询每日一练错题信息")
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
