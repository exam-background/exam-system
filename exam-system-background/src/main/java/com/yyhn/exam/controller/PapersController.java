package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.RandomMaxMin;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.*;
import com.yyhn.exam.service.*;
import com.yyhn.exam.service.impl.PapersUserResultServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@Api( value = "针对试卷进行维护",description = "试卷管理控制器类")
public class PapersController {
    @Resource
    private PapersService papersService;
    @Resource
    private PapersExerciseService papersExerciseService;
    @Resource
    private PapersTitleService papersTitleService;
    @Resource
    private PapersCourseService papersCourseService;

    @ApiOperation(value = "根据任意条件查询所有试卷", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据任意条件查询所有试卷")
    @GetMapping("/getPapers")
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

    @ApiOperation(value = "条件任意查询所有已发布试卷", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "条件任意查询所有已发布试卷")
    @GetMapping("/getPapersAllPublish")
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

    @ApiOperation(value = "根据试卷id删除试卷和试卷相关的表", httpMethod = "POST",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据试卷id删除试卷和试卷相关的表")
    @PostMapping("/delPapars")
    @Transactional(propagation= Propagation.SUPPORTS)
    public ResultMsg delPapers(@RequestBody List<Integer> integerList){
        try {
            papersService.deletePapersAll(integerList);
        }catch (RuntimeException runtimeException){
            return ResultMsg.BY_FAIL(runtimeException.getMessage());
        }
        return ResultMsg.BY_SUCCESS("成功", null);
    }

    @ApiOperation(value = "增加试卷", httpMethod = "POST",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "增加试卷")
    @PostMapping("/insertPapers")
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

    @ApiOperation(value = "发布试卷", httpMethod = "PUT",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "发布试卷")
    @PutMapping("/publishPapers")
    public ResultMsg publishPapers(@RequestBody Papers papers){
        if(papersService.publishPapers(papers.getId()) > 0){
            return ResultMsg.BY_SUCCESS("发布成功", null);
        }else{
            return ResultMsg.BY_FAIL("发布失败");
        }
    }

    @ApiOperation(value = "修改试卷信息", httpMethod = "PUT",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "修改试卷信息")
    @PutMapping("/updatePapers")
    public ResultMsg updatePapers(@RequestBody Papers papers){
        System.out.println("Papers:"+papers);
        if(papersService.updatePapers(papers) >= 1){
            return ResultMsg.BY_SUCCESS("修改成功", null);
        }else{
            return ResultMsg.BY_FAIL("修改失败");
        }
    }
}
