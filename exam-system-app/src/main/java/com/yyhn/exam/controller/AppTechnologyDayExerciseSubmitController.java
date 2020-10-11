package com.yyhn.exam.controller;

import com.yyhn.exam.common.Levenshtein;
import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.service.AppTechnologyDayExerciseItemService;
import com.yyhn.exam.service.AppTechnologyDayExerciseService;
import com.yyhn.exam.service.AppTechnologyDayExerciseSubmitService;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/TechnologyDayExerciseSubmitController")
@Api( value = "针对手机端技术每日一练做题记录进行维护",description = "手机端技术每日一练做题记录控制器类")
public class AppTechnologyDayExerciseSubmitController {
    @Resource
    private AppTechnologyDayExerciseSubmitService appTechnologyDayExerciseSubmitService;
    @Resource
    private AppTechnologyDayExerciseItemService appTechnologyDayExerciseItemService;
    @Resource
    private AppTechnologyDayExerciseService appTechnologyDayExerciseService;

    @ApiOperation(value = "添加技术每日一练做题记录", httpMethod = "POST",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "添加技术每日一练做题记录"+
            "<p>传参说明：</p>"+
            "<p>papersId: 需要查询的试卷id</p>"+
            "<p>userId: 参加考试的学生id</p>")
    @PostMapping("/addTechnologyDayExerciseSubmit")
    public ResultMsg addTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit){
        System.out.println(technologyDayExerciseSubmit);
        // 根据题目id拿到正确答案
        TechnologyDayExercise technologyDayExercise = appTechnologyDayExerciseService.getTechnologyDayExerciseById(technologyDayExerciseSubmit.getExerciseId());
        // 判断题目是否正确
        float leven = Levenshtein.getSimilarityRatio(technologyDayExerciseSubmit.getSubmitAnswer(), technologyDayExercise.getStandardAnswer());
        // 设置分数
        technologyDayExerciseSubmit.setScore(technologyDayExercise.getSetScore()*1.0f*leven);
        //是否正确
        int right = 1;
        // 如果当前分数小于总分数的90%则当前题目为错题
        float a = technologyDayExercise.getSetScore()*0.8f;
        if(a >= technologyDayExerciseSubmit.getScore()){
            right = 0;
        }
        technologyDayExerciseSubmit.setRight(right);
        if(appTechnologyDayExerciseSubmitService.addTechnologyDayExerciseSubmit(technologyDayExerciseSubmit) > 0){
            return ResultMsg.BY_SUCCESS("添加成功", null);
        }else{
            return ResultMsg.BY_FAIL("添加失败");
        }
    }

    @ApiOperation(value = "根据用户id拿到技术每日一练做题记录", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "添加技术每日一练做题记录")
    @GetMapping("/getTechnologyDayExerciseSubmitByUserId")
    public ResultMsg getTechnologyDayExerciseSubmitByUserId(Integer id){
        List<TechnologyDayExerciseSubmit> list = appTechnologyDayExerciseSubmitService.getTechnologyDayExerciseSubmitByUserId(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @ApiOperation(value = "根据用户id拿到技术每日一练错题记录", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "添加技术每日一练错题记录")
    @GetMapping("/getTechnologyDayExerciseSubmitByRight")
    public ResultMsg getTechnologyDayExerciseSubmitByRight(Integer id){
        List<TechnologyDayExerciseSubmit> list = appTechnologyDayExerciseSubmitService.getTechnologyDayExerciseSubmitByRight(id);
        if(list != null){
            //判断是否为选择题，如果为选择题则查询选择题选项
            List<TechnologyDayExerciseSubmit> listAll = new ArrayList<TechnologyDayExerciseSubmit>();
            for(TechnologyDayExerciseSubmit technologyDayExerciseSubmit : list) {
                if(Integer.parseInt(technologyDayExerciseSubmit.getTechnologyDayExercise().getTypes()) == 2){
                    //根据题目id查询题目选择题
                    technologyDayExerciseSubmit.getTechnologyDayExercise().setExerciseItems(appTechnologyDayExerciseItemService.getTechnologyDayExerciseByExerciseId(technologyDayExerciseSubmit.getTechnologyDayExercise().getId()));
                }
                listAll.add(technologyDayExerciseSubmit);
            }
            return ResultMsg.BY_SUCCESS("查询成功", listAll);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
