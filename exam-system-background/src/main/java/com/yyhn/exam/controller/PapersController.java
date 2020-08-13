package com.yyhn.exam.controller;

import com.yyhn.exam.common.RandomMaxMin;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.*;
import com.yyhn.exam.service.*;
import com.yyhn.exam.service.impl.PapersUserResultServiceImpl;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PapersController {
    @Resource
    private PapersService papersService;
    @Resource
    private PapersExerciseService papersExerciseService;
    @Resource
    private PapersUserService papersUserService;
    @Resource
    private PapersTitleService papersTitleService;
    @Resource
    private PapersCourseService papersCourseService;
    @Resource
    private TechnologyDayExerciseService technologyDayExerciseService;
    @Resource
    private TechnologyDayExerciseItemService technologyDayExerciseItemService;
    @Resource
    private PapersUserResultServiceImpl papersUserResultService;
    @Resource
    private JobExampleStudyService jobExampleStudyService;

    /**
     * 条件查询所有试卷
     * @param papers
     * @return
     */
    @RequestMapping("/getPapers")
    public ResultMsg getPapers(Papers papers){
        System.out.println(papers);
        List<Papers> list = papersService.getPapersAll(papers);
        if(list != null){
            List<Papers> papersList = new ArrayList<Papers>();
            for(Papers p : list){
                String[] courseId = new String[p.getCourseList().size()];
                for(int i=0;i<p.getCourseList().size();i++){
                    p.setCourse(p.getCourse()+p.getCourseList().get(i).getCourseName()+";");
                    courseId[i] = String.valueOf(p.getCourseList().get(i).getId());
                }
                p.setCourseId(courseId);
                if(p.getType()==1){
                    p.setTypeString("技术考核");
                }
                String[] userId = new String[p.getStudentList().size()];
                for(int i=0;i<p.getStudentList().size();i++){
                    userId[i] = String.valueOf(p.getStudentList().get(i).getId());
                }
                p.setUserId(userId);
                if(p.getIspublish() == 1){
                    p.setIspublishString("已发布");
                }
                papersList.add(p);
            }
            return ResultMsg.BY_SUCCESS("查询成功", papersList);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    /**
     * 条件查询所有已发布试卷
     * @param papers
     * @return
     */
    @RequestMapping("/getPapersAllPublish")
    public ResultMsg getPapersAllPublish(Papers papers){
        System.out.println(papers);
        List<Papers> list = papersService.getPapersAllPublish(papers);
        if(list != null){
            List<Papers> papersList = new ArrayList<Papers>();
            for(Papers p : list){
                String[] courseId = new String[p.getCourseList().size()];
                for(int i=0;i<p.getCourseList().size();i++){
                    p.setCourse(p.getCourse()+p.getCourseList().get(i).getCourseName()+";");
                    courseId[i] = String.valueOf(p.getCourseList().get(i).getId());
                }
                p.setCourseId(courseId);
                if(p.getType()==1){
                    p.setTypeString("技术考核");
                }
                String[] userId = new String[p.getStudentList().size()];
                for(int i=0;i<p.getStudentList().size();i++){
                    userId[i] = String.valueOf(p.getStudentList().get(i).getId());
                }
                p.setUserId(userId);
                if(p.getIspublish() == 1){
                    p.setIspublishString("已发布");
                }
                papersList.add(p);
            }
            return ResultMsg.BY_SUCCESS("查询成功", papersList);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @RequestMapping("/delPapars")
    @Transactional(propagation= Propagation.SUPPORTS)
    public ResultMsg delPapers(@RequestBody List<Integer> integerList){
        try {
            for (Integer id : integerList) {
                System.out.println("============================>" + id);
                //删除考试用户表中的数据
//                papersUserService.deletePapersUser(id);
                //删除考生作答表中的该试卷的数据
//                papersUserResultService.deletePapersUserResult(id);
                //删除题目备选答案表中该试卷的题目的备选答案
                //查询该id下的所有题目
                List<PapersTitle> papersTitleList = papersTitleService.getPapersTitleByPapersId(id);
                for(PapersTitle papersTitle : papersTitleList){
                    papersExerciseService.deletePapersExercise(papersTitle.getId());
                }
                //删除该试卷对应试题表中该试卷的题目
                papersTitleService.deletePapersTitle(id);
                //删除试卷，科目关系表中与该试卷相关联的记录
                papersCourseService.deletePapersCourse(id);
                //删除试卷表中的试卷
                papersService.deletePapers(id);
            }
        }catch (RuntimeException runtimeException){
            return ResultMsg.BY_FAIL(runtimeException.getMessage());
        }
        return null;
    }

    @RequestMapping("/insertPapers")
    public ResultMsg insertPapers(@RequestBody Papers papers){
        try{
            System.out.println("Papers:"+papers);
            //增加试卷表数据
            papersService.insertPapers(papers);
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
                    int courseCount = jobExampleStudyService.getJobExampleStudyByCourse(papers.getProfessionalId(), Integer.valueOf(papers.getCourseId()[i]));
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
                        int result = RandomMaxMin.getRandomMaxMin(courseCount, 0, list);
                        list.add(result);
                        //拿到本张试卷没拿过的题目
                        JobExampleStudy jobExampleStudy = jobExampleStudyService.getJobExampleStudyBypProfessionalCourse(papers.getProfessionalId(), Integer.valueOf(papers.getCourseId()[i]), result);
                        //试卷添加的题目
                        PapersTitle papersTitle = new PapersTitle(null, papers.getId(), jobExampleStudy.getTitle(), jobExampleStudy.getRemark(), jobExampleStudy.getScore(), jobExampleStudy.getAnswer(), null);
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
                    int courseCount = technologyDayExerciseService.getTechnologyDayExerciseByCourse(papers.getProfessionalId(), Integer.valueOf(papers.getCourseId()[i]));
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
                        int result = RandomMaxMin.getRandomMaxMin(courseCount, 0, list);
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
                            PapersExercise papersExercise = new PapersExercise(null, papersTitle.getId(), papersTitle.getId(), technologyDayExerciseItem.getContent(), technologyDayExerciseItem.getOrderNum());
                            papersExerciseService.insertPapersExercise(papersExercise);
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
        }catch (RuntimeException runtimeException){
            return ResultMsg.BY_FAIL(runtimeException.getMessage());
        }catch (Exception e){
            return ResultMsg.BY_FAIL(e.getMessage());
        }
        return ResultMsg.BY_SUCCESS("添加成功", null);
    }

    @RequestMapping("/updatePapers")
    public ResultMsg updatePapers(@RequestBody Papers papers){
        System.out.println("Papers:"+papers);
        return null;
    }

    @RequestMapping("/publishPapers")
    public ResultMsg publishPapers(Integer id){
        if(papersService.publishPapers(id) > 0){
            return ResultMsg.BY_SUCCESS("发布成功", null);
        }else{
            return ResultMsg.BY_FAIL("发布失败");
        }
    }
}
