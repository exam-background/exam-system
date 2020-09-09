package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Levenshtein;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.mapper.AppPapersUserResultMapper;
import com.yyhn.exam.service.AppPapersExerciseService;
import com.yyhn.exam.service.AppPapersTitleService;
import com.yyhn.exam.service.AppPapersUserResultService;
import com.yyhn.exam.service.AppPapersUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppPapersUserResultServiceImpl implements AppPapersUserResultService {
    @Resource
    private AppPapersUserResultMapper appPapersUserResultMapper;
    @Resource
    private AppPapersUserService appPapersUserService;
    @Resource
    private AppPapersTitleService appPapersTitleService;

    @Override
    public List<PapersUserResult> getPapersUserResultByRight(Integer papersId, Integer userid) {
        return appPapersUserResultMapper.getPapersUserResultByRight(papersId, userid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void insertPapersUserResult(List<PapersUserResult> papersUserResultList) throws RuntimeException{
        for(PapersUserResult papersUserResult:papersUserResultList) {
            //添加作答
            if(appPapersUserResultMapper.insert(papersUserResult) <= 0){
                throw new RuntimeException("学生作答信息增加失败");
            }
            //根据作答表的记录查询正确答案
            List<PapersTitle> list = appPapersTitleService.getPapersTitleByPapersid(papersUserResult.getPapersId());
            //根据正确答案修改作答表分数
            for (PapersTitle papersTitle : list) {
                papersUserResult.setPapersExercise(papersTitle.getStandardAnswer());
                papersUserResult.setSetScore(papersTitle.getSetScore());
                float leven = Levenshtein.getSimilarityRatio(papersUserResult.getUserExercise(), papersUserResult.getPapersExercise());
                // 设置得分
                papersUserResult.setMark(((float) papersUserResult.getSetScore()) * leven);
                // 判断对错
                int right = 1;
                if (papersUserResult.getSetScore() * 0.8 >= papersUserResult.getMark()) {
                    right = 0;
                }
                papersUserResult.setRight(right);
                if (this.updatePapersUserResult(papersUserResult) <= 0) {
                    throw new RuntimeException("更改题目信息失败");
                }
                if(appPapersUserService.updateIsPapers(papersUserResult.getUserId(), papersUserResult.getPapersId()) <= 0){
                    throw new RuntimeException("更新试卷作答记录失败");
                }
            }
        }
    }

    @Override
    public int updatePapersUserResult(PapersUserResult papersUserResult) {
        return appPapersUserResultMapper.updateById(papersUserResult);
    }
}
