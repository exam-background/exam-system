package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersExercise;
import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.service.PapersExerciseService;
import com.yyhn.exam.service.PapersTitleService;
import com.yyhn.exam.service.PapersUserResultService;
import com.yyhn.exam.service.PapersUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PapersUserResultController {
    @Resource
    private PapersUserResultService papersUserResultService;
    @Resource
    private PapersExerciseService papersExerciseService;

    @RequestMapping("/updatePapersUserResult")
    public ResultMsg updatePapersUserResult(PapersUserResult papersUserResult){
        if(papersUserResultService.updatePapersUserResult(papersUserResult) > 0){
            return ResultMsg.BY_SUCCESS("修改成功", null);
        }else {
            return ResultMsg.BY_FAIL("修改失败");
        }
    }

    @RequestMapping("/getPapersUserByUserId")
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
