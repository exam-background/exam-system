package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.service.ClassService;
import com.yyhn.exam.service.JobExampleStudyService;
import com.yyhn.exam.vo.JobExamStudySearchVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@RestController
@Api( value = "针对示范学习信息进行维护",description = "示范学习控制器类")
public class JobExampleStudyController {

    @Resource
    JobExampleStudyService jobExampleStudyService;


    @ApiOperation(value = "查询所有示范学习信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "根据条件查询示范学习信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/jobExampleStudyForPage")
    public Dto<List<JobExampleStudy>> jobExampleStudyForPage(
                                         JobExamStudySearchVO vo){

        System.out.println("vo.toString() = " + vo.toString());


        Page<List<JobExampleStudy>> page = new Page<List<JobExampleStudy>>();
        try {
            page.setPageSize(vo.getPageSize());
            page.setCurPage(vo.getCurrentPage());
            jobExampleStudyService.getAllJobExampleStudy(vo.getTitle(),vo.getProName(),vo.getCoName(),page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }



   @PostMapping("/addJobExampleStudy")
    public Dto<Object> addJobExampleStudy(JobExampleStudy jobExampleStudy, Integer professionalId, Integer courseId, HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Origin","*");
        try {
            jobExampleStudy.getProfessional().setId(professionalId);
            jobExampleStudy.getCourse().setId(courseId);
            int count = jobExampleStudyService.addJobExampleStudy(jobExampleStudy);
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


    @PostMapping("/updateJobExampleStudy")
    public Dto<Object> updateJobExampleStudy(JobExampleStudy jobExampleStudy){

        try {
            int count = jobExampleStudyService.updateJobExampleStudy(jobExampleStudy);
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


    @ApiOperation(value = "删除示范学习", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "删除示范学习 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除示范学习失败 </p>" +
            "<p>0 : 删除示范学习成功 </p>" )
    @RequestMapping(value = "/deleteJobExampleStudy/{id}",method = RequestMethod.GET)
    public Dto<Object> deleteJobExampleStudy(@PathVariable Integer id){
        try {
            if(id!=null){
                int count = jobExampleStudyService.deleteJobExampleStudy(id);
                if(count>0) return DtoUtil.returnSuccess("删除成功！");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return DtoUtil.returnFail("删除失败，或是系统错误","100101");
    }

    @ApiOperation(value = "根据ID查询示范学习", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "根据ID查询示范学习 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 根据ID查询范学习失败 </p>" +
            "<p>0 : 根据ID查询范学习成功 </p>" )
    @RequestMapping(value = "/getJobExampleStudyById/{id}",method = RequestMethod.GET)
    public Dto<Object> getJobExampleStudyById(@PathVariable Integer id){
        try {
            if(id !=null){
                JobExampleStudy jobExampleStudy =jobExampleStudyService.getJobExampleStudyById(id);
                if(jobExampleStudy.getId()!=null) return DtoUtil.returnSuccess("查询成功",jobExampleStudy);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return DtoUtil.returnFail("系统错误，或者没有此示例","100101");
    }


}


