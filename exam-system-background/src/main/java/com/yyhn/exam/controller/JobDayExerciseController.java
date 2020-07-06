package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.service.JobDayExerciseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对就业每日一练信息进行维护",description = "就业每日一练控制器类")
public class JobDayExerciseController  {

    @Resource
    private JobDayExerciseService jobDayExerciseService;


    @ApiOperation(value = "查询所有就业每日一练信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "根据条件查询就业每日一练信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/jobDayExerciseForPage",method = RequestMethod.GET)
    public Dto<List<JobDayExercise>> jobDayExerciseForPage(
            String title,
            Integer professionalId,
            Integer courseId,
            @RequestParam(defaultValue = "2")
                    String pageSize,
            @RequestParam(defaultValue = "1")
                    Integer currentPage){
        Page<List<JobDayExercise>> page = new Page<List<JobDayExercise>>();
        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            jobDayExerciseService.getAllJobDayExercise(title,professionalId,courseId,page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }


    @ApiOperation(value = "增加就业每日一练信息", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加就业每日一练信息 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加就业每日一练信息失败 </p>" +
            "<p>0 : 添加就业每日一练信息成功 </p>" )
    @RequestMapping(value = "/addJobDayExercise",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> addJobDayExercise(JobDayExercise jobDayExercise,Integer professionalId,Integer courseId){
        try {
            jobDayExercise.getProfessional().setId(professionalId);
            jobDayExercise.getCourse().setId(courseId);

            int count = jobDayExerciseService.addJobDayExercise(jobDayExercise);
            if(count>0){
                return DtoUtil.returnSuccess("添加成功！");
            }else {
                return DtoUtil.returnFail("添加失败","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "修改就业每日一练信息", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "修改就业每日一练信息 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 修改就业每日一练信息失败 </p>" +
            "<p>0 : 修改就业每日一练信息成功 </p>" )
    @RequestMapping(value = "/updateJobDayExercise",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> updateJobDayExercise(JobDayExercise jobDayExercise,Integer professionalId,Integer courseId){
        jobDayExercise.getProfessional().setId(professionalId);
        jobDayExercise.getCourse().setId(courseId);

        try {
            int count = jobDayExerciseService.updateJobDayExercise(jobDayExercise);
            if(count>0){
                return DtoUtil.returnSuccess("修改成功！");
            }else {
                return DtoUtil.returnFail("修改失败！","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "删除就业每日一练", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "删除就业每日一练 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除就业每日一练失败 </p>" +
            "<p>0 : 删除就业每日一练成功 </p>" )
    @RequestMapping(value = "/deleteJobDayExercise",method = RequestMethod.GET)
    public Dto<Object> deleteJobDayExercise(String id){
        try {
            int count = jobDayExerciseService.deleteJobDayExercise(Integer.valueOf(id));
            if(count>0){
                return DtoUtil.returnSuccess("删除成功！");
            }else {
                return DtoUtil.returnFail("删除失败","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "根据ID查询就业每日一练", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "根据ID查询就业每日一练 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 根据ID查询就业每日一练失败 </p>" +
            "<p>0 : 根据ID查询就业每日一练成功 </p>" )
    @RequestMapping(value = "/getJobDayExerciseById",method = RequestMethod.GET)
    public Dto<Object> getJobDayExerciseById(String id){
        try {
            JobDayExercise jobDayExercise = jobDayExerciseService.getJobDayExerciseById(Integer.valueOf(id));
            if(jobDayExercise!=null){
                return DtoUtil.returnSuccess("查询成功！",jobDayExercise);
            }else {
                return DtoUtil.returnFail("查询失败","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

}
