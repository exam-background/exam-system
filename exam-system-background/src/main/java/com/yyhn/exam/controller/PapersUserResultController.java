package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersExercise;
import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.service.PapersExerciseService;
import com.yyhn.exam.service.PapersTitleService;
import com.yyhn.exam.service.PapersUserResultService;
import com.yyhn.exam.service.PapersUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api( value = "针对试卷学生作答进行维护",description = "试卷管理学生作答控制器类")
public class PapersUserResultController {
    @Resource
    private PapersUserResultService papersUserResultService;
    @Resource
    private PapersExerciseService papersExerciseService;

    @ApiOperation(value = "根据学生id修改学生作答题目分数", httpMethod = "PUT",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据学生id修改学生作答题目分数")
    @PutMapping("/updatePapersUserResult")
    public ResultMsg updatePapersUserResult(PapersUserResult papersUserResult){
        if(papersUserResultService.updatePapersUserResult(papersUserResult) > 0){
            return ResultMsg.BY_SUCCESS("修改成功", null);
        }else {
            return ResultMsg.BY_FAIL("修改失败");
        }
    }

    @ApiOperation(value = "根据学生id和试卷id查询学生作答信息", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据学生id和试卷id查询学生作答信息")
    @GetMapping("/getPapersUserByUserId")
    public ResultMsg getPapersUserByUserId(Integer id, Integer papersId){
        //查询考生答题内容和外键题目信息
        List<PapersUserResult> papersUserResultList = papersUserResultService.getPapersUserResultByUserId(id, papersId);
        if(papersUserResultList != null){
            //根据题目信息获取备选答案
            List<PapersUserResult> papersUserResults = new ArrayList<PapersUserResult>();
            for(PapersUserResult papersUserResult : papersUserResultList){
                papersUserResult.getPapersTitle().setPapersExercises(papersExerciseService.getPapersExerciseByTitleId(papersUserResult.getPapersTitle().getId()));
                papersUserResults.add(papersUserResult);
            }
            return ResultMsg.BY_SUCCESS("查询成功", papersUserResults);
        }else {
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
