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
    private PapersTitleService papersTitleService;
    @Resource
    private PapersCourseService papersCourseService;

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
            // 添加试卷和相应表的数据
            papersService.insertPapersAll(papers);
        }catch (RuntimeException runtimeException){
            System.out.println("抛出事务异常");
            System.out.println(runtimeException.getMessage());
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
