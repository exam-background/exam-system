package com.yyhn.exam.controller;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.service.AppJobDayExerciseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/AppJobDayExerciseController")
@Api( value = "针对手机端就业每日一练进行维护",description = "手机端就业每日一练控制器类")
public class AppJobDayExerciseController {
    @Resource
    private AppJobDayExerciseService appJobDayExerciseService;

    @ApiOperation(value = "手机端根据专业id拿到每日一练信息(数据分页)", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "每日一练增加做题记录<br/>"+
            "<p>传参说明：</p><br/>"+
            "<p>id: 根据专业id查询，0表示查询所有</p><br/>"+
            "<p>pageSize: 每页显示的条数</p><br/>"+
            "<p>currentPage: 当前页数</p>")
    @GetMapping("/getJobDayExerciseByProfessid")
    public ResultMsg getJobDayExerciseByProfessid(Integer id, @RequestParam(defaultValue = "2")String pageSize, @RequestParam(defaultValue = "1")Integer currentPage){
        Page<List<JobDayExercise>> page = new Page<List<JobDayExercise>>();
        page.setPageSize(Integer.valueOf(pageSize));
        page.setCurPage(currentPage);

        appJobDayExerciseService.getJobDayExerciseByProfessid(id, page);
        if(page != null){
            return ResultMsg.BY_SUCCESS("查询成功", page);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
