package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.JobExampleStudy;
import com.yyhn.exam.service.ClassService;
import com.yyhn.exam.service.JobExampleStudyService;
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
    @RequestMapping(value = "/jobExampleStudyForPage",method = RequestMethod.GET)
    public Dto<List<JobExampleStudy>> jobExampleStudyForPage(
                                         String title,
                                         Integer professionalId,
                                         Integer courseId,
                                         @RequestParam(defaultValue = "2")
                                         String pageSize,
                                         @RequestParam(defaultValue = "1")
                                         Integer currentPage){
        Page<List<JobExampleStudy>> page = new Page<List<JobExampleStudy>>();
        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            jobExampleStudyService.getAllJobExampleStudy(title,professionalId,courseId,page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }


    @ApiOperation(value = "增加示范学习信息", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加示范学习信息 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加示范学习信息失败 </p>" +
            "<p>0 : 添加示范学习信息成功 </p>" )
    @RequestMapping(value = "/addJobExampleStudy",
                    method = RequestMethod.POST,
                    consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
                    produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
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


    @ApiOperation(value = "修改示范学习", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "修改示范学习 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 修改示范学习失败 </p>" +
            "<p>0 : 修改示范学习成功 </p>" )
    @RequestMapping(value = "/updateJobExampleStudy",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> updateJobExampleStudy(JobExampleStudy jobExampleStudy,Integer professionalId,Integer courseId){
        jobExampleStudy.getProfessional().setId(professionalId);
        jobExampleStudy.getCourse().setId(courseId);

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
    @RequestMapping(value = "/deleteJobExampleStudy",method = RequestMethod.GET)
    public Dto<Object> deleteJobExampleStudy(String id){
        try {
            int count = jobExampleStudyService.deleteJobExampleStudy(Integer.valueOf(id));
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

    @ApiOperation(value = "根据ID查询示范学习", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "根据ID查询示范学习 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 根据ID查询范学习失败 </p>" +
            "<p>0 : 根据ID查询范学习成功 </p>" )
    @RequestMapping(value = "/getJobExampleStudyById",method = RequestMethod.GET)
    public Dto<Object> getJobExampleStudyById(String id){
        try {
            JobExampleStudy jobExampleStudy =jobExampleStudyService.getJobExampleStudyById(Integer.valueOf(id));
            if(jobExampleStudy!=null){
                return DtoUtil.returnSuccess("查询成功！",jobExampleStudy);
            }else {
                return DtoUtil.returnFail("查询成功","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


}


