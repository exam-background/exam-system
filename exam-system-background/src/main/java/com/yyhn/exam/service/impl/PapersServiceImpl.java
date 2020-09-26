package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.RandomMaxMin;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.*;
import com.yyhn.exam.mapper.PapersMapper;
import com.yyhn.exam.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class PapersServiceImpl implements PapersService {
    @Resource
    private PapersMapper papersMapper;
    @Resource
    private TechnologyDayExerciseService technologyDayExerciseService;
    @Resource
    private PapersUserService papersUserService;
    @Resource
    private TechnologyDayExerciseItemService technologyDayExerciseItemService;
    @Resource
    private JobDayExerciseService jobDayExerciseService;
    @Resource
    private PapersCourseService papersCourseService;
    @Resource
    private PapersTitleService papersTitleService;
    @Resource
    private PapersExerciseService papersExerciseService;
    @Resource
    private PapersUserResultService papersUserResultService;

    @Override
    public List<Papers> getPapersAll(Papers papers) {
        return papersMapper.getPapersAll(papers);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void deletePapers(Integer id) throws RuntimeException{
        if(papersMapper.deleteById(id) < 0){
            throw new RuntimeException("试卷删除失败");
        }
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void insertPapers(Papers papers) throws RuntimeException{
        if(papersMapper.insert(papers) < 0){
            throw new RuntimeException("试卷增加失败");
        }
        System.out.println("试卷增加完成");
    }

    @Override
    public int publishPapers(Integer id) {
        Papers papers = new Papers();
        papers.setIspublish(1);
        papers.setId(id);
        return papersMapper.updateById(papers);
    }

    @Override
    public List<Papers> getPapersAllPublish(Papers papers) {
        return papersMapper.getPapersAllPublish(papers);
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void insertPapersAll(Papers papers) throws RuntimeException, Exception{
        System.out.println("Papers:"+papers);
        //增加试卷表数据
        this.insertPapers(papers);
        //增加考试，科目关系表
        PapersCourse papersCourse=null;
        //简答题数量
        int type1Cont = 0;
        for(int i=0;i<papers.getCourseId().length;i++){
            papersCourse = new PapersCourse(null, papers.getId(), Integer.valueOf(papers.getCourseId()[i]), papers.getProfessionalId());
            papersCourseService.insertPapersCourse(papersCourse);

            //判断从就业训练还是从技术训练中拿取题目
            if(papers.getType() == 0){
                //增加考试题目表
                //考试的科目在数据库中总共有多少题目
                int courseCount = jobDayExerciseService.getJobDayExerciseByCourse(papers.getProfessionalId(), Integer.valueOf(papers.getCourseId()[i]));
                if(courseCount == 0){
                    throw new Exception("该科目暂无题目");
                }
                //每个专业科目从数据库拿多少题
                int professional = papers.getSum()/papers.getCourseId().length;
                boolean testa = papers.getSum()%papers.getCourseId().length != 0;
                boolean testb = i == papers.getCourseId().length-1;
                if(testa && testb){
                    professional = papers.getSum()/papers.getUserId().length+papers.getSum()%papers.getUserId().length;
                }
                //记录拿过哪些题目的id
                List<Integer> list = new ArrayList<Integer>();
                for(int a=0;a<professional;a++){
                    int result = RandomMaxMin.getRandomMaxMin(courseCount-1, 0, list);
                    list.add(result);
                    //拿到本张试卷没拿过的题目
                    JobDayExercise jobDayExercise = jobDayExerciseService.getJobDayExerciseBypProfessionalCourse(papers.getProfessionalId(), Integer.valueOf(papers.getCourseId()[i]), result);
                    //试卷添加的题目
                    PapersTitle papersTitle = new PapersTitle(null, papers.getId(), jobDayExercise.getTitle(), jobDayExercise.getRemark(), jobDayExercise.getScore(), jobDayExercise.getAnswer(), 1);
                    //设置分数
                    switch (papers.getSum()){
                        case 2:
                            papersTitle.setSetScore(50);
                            break;
                        case 10:
                            papersTitle.setSetScore(10);
                            break;
                        case 50:
                            papersTitle.setSetScore(2);
                            break;
                    }
                    //添加题目
                    papersTitleService.insertPapersTitle(papersTitle);
                }
            }else{
                //增加考试题目表
                //考试的科目在数据库中总共有多少题目
                int courseCount = technologyDayExerciseService.getTechnologyDayExerciseByCourse(papers.getProfessionalId(), Integer.valueOf(papers.getCourseId()[i]), papers.getSum(), papers.getCourseId().length);
                if(courseCount == 0){
                    throw new Exception("该科目暂无题目");
                }
                //每个专业科目从数据库拿多少题
                int professional = papers.getSum()/papers.getCourseId().length;
                boolean testa = papers.getSum()%papers.getCourseId().length != 0;
                boolean testb = i == papers.getCourseId().length-1;
                if(testa && testb){
                    professional = papers.getSum()/papers.getUserId().length+papers.getSum()%papers.getUserId().length;
                }
                //记录拿过哪些题目的id
                List<Integer> list = new ArrayList<Integer>();
                for(int a=0;a<professional;a++){
                    int result = RandomMaxMin.getRandomMaxMin(courseCount-1, 0, list);
                    list.add(result);
                    //拿到本张试卷没拿过的题目
                    TechnologyDayExercise technologyDayExercise = technologyDayExerciseService.getTechnologyDayExerciseBypProfessionalCourse(papers.getProfessionalId(), Integer.valueOf(papers.getCourseId()[i]), result);
                    //试卷添加的题目
                    PapersTitle papersTitle = new PapersTitle(null, papers.getId(), technologyDayExercise.getTitle(), technologyDayExercise.getAnalysis(), technologyDayExercise.getSetScore(), technologyDayExercise.getStandardAnswer(), Integer.valueOf(technologyDayExercise.getTypes()));
                    //简答题设置分数为10分
                    if(papersTitle.getType() == 1){
                        papersTitle.setSetScore(10);
                        type1Cont++;
                    }
                    //添加题目
                    papersTitleService.insertPapersTitle(papersTitle);

                    //增加考试题目备选答案表
                    //查询题目的备选答案
                    List<TechnologyDayExerciseItem> technologyDayExerciseList = technologyDayExerciseItemService.getTechnologyDayExerciseByExerciseId(technologyDayExercise.getId());
                    //添加备选答案
                    for(TechnologyDayExerciseItem technologyDayExerciseItem : technologyDayExerciseList){
                        if(technologyDayExerciseItem != null){
                            PapersExercise papersExercise = new PapersExercise(null, papers.getId(), papersTitle.getId(), technologyDayExerciseItem.getContent(), technologyDayExerciseItem.getOrderNum());
                            papersExerciseService.insertPapersExercise(papersExercise);
                        }
                    }
                }
                //总分减去简答题的分数后剩余的分数分配给选择题
                int sum = (100-type1Cont*10)/(papers.getSum()-type1Cont);
                PapersTitle papersTitleScore = new PapersTitle();
                papersTitleScore.setType(1);
                papersTitleScore.setSetScore(sum);
                papersTitleScore.setPapersId(papers.getId());
                papersTitleService.updatePapersTitleByScore(papersTitleScore);
            }
        }
        //增加考试用户表
        PapersUser papersUser = new PapersUser();
        for(int c=0;c<papers.getUserId().length;c++){
            papersUser.setPapersId(papers.getId());
            papersUser.setUserId(Integer.valueOf(papers.getUserId()[c]));
            papersUser.setCount(papers.getSum());
            papersUserService.insertPapersUser(papersUser);
        }
    }

    @Override
    public void deletePapersAll(List<Integer> integerList) throws RuntimeException {
        for (Integer id : integerList) {
            //删除考试用户表中的数据
            if(papersUserService.deletePapersUser(id) == 0){
                throw new RuntimeException("试卷考试学生删除失败");
            }
            //删除考生作答表中的该试卷的数据
            if(papersUserResultService.deletePapersUserResult(id) == 0){
                throw new RuntimeException("试卷题目删除失败");
            }
            //删除题目备选答案表中该试卷的题目的备选答案
            //查询该id下的所有题目
            List<PapersTitle> papersTitleList = papersTitleService.getPapersTitleByPapersId(id);
            for(PapersTitle papersTitle : papersTitleList){
                if(papersExerciseService.deletePapersExercise(papersTitle.getId()) == 0){
                    throw new RuntimeException("题目备选答案删除失败");
                }
            }
            //删除该试卷对应试题表中该试卷的题目
            if(papersTitleService.deletePapersTitle(id) == 0){
                throw new RuntimeException("试卷题目删除失败");
            }
            //删除试卷，科目关系表中与该试卷相关联的记录
            if(papersCourseService.deletePapersCourse(id) == 0){
                throw new RuntimeException("试卷，科目关系表删除失败");
            }
            //删除试卷表中的试卷
            if(papersMapper.deleteById(id) == 0){
                throw new RuntimeException("试卷删除失败");
            }
        }
    }

    @Override
    public int updatePapers(Papers papers) {
        return papersMapper.updateById(papers);
    }

    @Override
    public List<Papers> getPapersByUserIdAndtypeFinish(Integer userId, Integer type) {
        List<Papers> listAll = papersMapper.getPapersByUserIdAndtypeFinish(userId, type);
        List<Papers> list = new ArrayList<Papers>();
        for (Papers papers : listAll){
            if(papers.getType() == 0){
                papers.setTypeName("就业训练");
            }
            papers.setPapersTitleList(papersTitleService.getPapersTitleByPapersId(papers.getId()));
            papers.setPapersUserResultList(papersUserResultService.getPapersUserResultByUserId(userId, papers.getId()));
            list.add(papers);
        }
        return list;
    }

    @Override
    public List<Papers> getPapersByUserId(Integer userId) {
        return papersMapper.getPapersByUserId(userId);
    }

    @Override
    public List<Papers> getPapersByType(Integer classId, String papersName, Integer type) {
        List<Papers> list = new ArrayList<Papers>();
        for(Papers papers : papersMapper.getPapersByType(classId, papersName, type)){
            // 添加试卷考试学生
            List<PapersUser> papersUserList = new ArrayList<PapersUser>();
            // 添加试卷考试学生作答
            List<PapersUserResult> papersUserResultList = new ArrayList<PapersUserResult>();
            for(PapersUser papersUser : papersUserService.getPapersUserByPapersId(papers.getId())){
                float countScore = 0;
                float studentScore = 0;
                for(PapersUserResult papersUserResult : papersUserResultService.getPapersUserResultByUserId(papersUser.getUserId(), papers.getId())){
                    countScore+=papersUserResult.getSetScore();
                    studentScore+=papersUserResult.getMark();
                    papersUserResultList.add(papersUserResult);
                }
                if(studentScore>=90){
                    papers.setPapersPass(papers.getPapersPass()+1);
                }
                papersUser.setCountScore(countScore);
                papersUser.setStudentScore(studentScore);
                papersUserList.add(papersUser);
            }
            if(papers.getPapersPass() == 0){
                papers.setPercentOfPass("0%");
            }else{
                float a = papers.getStudentList().size() * 1.0f;
                float b = papers.getPapersPass() * 1.0f;
                papers.setPercentOfPass((a / b) + "%");
            }
            papers.setPapersUserList(papersUserList);
            papers.setPapersUserResultList(papersUserResultList);
            list.add(papers);
        }
        return list;
    }
}
