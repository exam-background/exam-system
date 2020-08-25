package com.yyhn.exam.controller;

import com.yyhn.exam.common.Page;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.service.AppJobDayExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/AppJobDayExerciseController")
public class AppJobDayExerciseController {
    @Resource
    private AppJobDayExerciseService appJobDayExerciseService;

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
