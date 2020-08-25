package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersExercise;
import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.service.AppPapersExerciseService;
import com.yyhn.exam.service.AppPapersTitleService;
import com.yyhn.exam.service.AppPapersUserResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/AppPapersUserResultController")
public class AppPapersUserResultController {
    @Resource
    private AppPapersUserResultService appPapersUserResultService;
    @Resource
    private AppPapersExerciseService appPapersExerciseService;
    @Resource
    private AppPapersTitleService appPapersTitleService;

    @GetMapping("/getPapersUserResultByRight")
    public ResultMsg getPapersUserResultByRight(Integer papersId,Integer userId){
        List<PapersUserResult> list = appPapersUserResultService.getPapersUserResultByRight(papersId, userId);
        if(list != null){
            //判断是否为选择题，如果为选择题则查询选择题选项
            List<PapersUserResult> listAll = new ArrayList<PapersUserResult>();
            for(PapersUserResult papersUserResult : list) {
                if(papersUserResult.getPapersTitle().getType() == 2){
                    //根据题目id查询题目选择题
                    papersUserResult.getPapersTitle().setPapersExercises(appPapersExerciseService.getPapersExerciseByTitleId(papersUserResult.getPapersTitle().getId()));
                }
                listAll.add(papersUserResult);
            }
            return ResultMsg.BY_SUCCESS("查询成功", listAll);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @PostMapping("/insertPapersUserResult")
    public ResultMsg insertPapersUserResult(PapersUserResult papersUserResult){
        //添加作答
        appPapersUserResultService.insertPapersUserResult(papersUserResult);
        //根据作答表的记录查询正确答案
        List<PapersTitle> list = appPapersTitleService.getPapersTitleByPapersid(papersUserResult.getPapersId());
        //根据正确答案修改作答表分数
        for(PapersTitle papersTitle : list){
            papersUserResult.setPapersExercise(papersTitle.getStandardAnswer());
            papersUserResult.setSetScore(papersTitle.getSetScore());
            if (appPapersUserResultService.updatePapersUserResult(papersUserResult) <=0) {
                return ResultMsg.BY_FAIL("更改题目信息失败");
            }
        }
        return ResultMsg.BY_SUCCESS("添加考试信息成功", null);
    }
}