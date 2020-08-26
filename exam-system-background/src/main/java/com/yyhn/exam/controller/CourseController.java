package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Course;
import com.yyhn.exam.entity.Professional;
import com.yyhn.exam.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对科目信息进行维护",description = "科目管理控制器类")
public class CourseController {

    @Resource
    private CourseService courseService;


    @ApiOperation(value = "查询科目信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "根据条件查询所有科目信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/courseForPage",method = RequestMethod.GET)
    public Dto<List<Course>> courseForPage(String courseName,
                                           @RequestParam(defaultValue = "5")
                                                               String pageSize,
                                           @RequestParam(defaultValue = "1")
                                                               Integer currentPage){
        Page<List<Course>> page = new Page<List<Course>>();
        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            courseService.getCourse(courseName,page);
        }catch (Exception ex){
            ex.printStackTrace();
            DtoUtil.returnFail("查询失败！","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }

    @ApiOperation(value = "增加科目信息", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加科目 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加科目失败 </p>" +
            "<p>0 : 添加科目成功 </p>" )
    @RequestMapping(value = "/addCourse",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> addCourse(Course course,Integer professionalId ){
        try {
            //int count = professionalService.addProfessional(professional);
            course.getProfessional().setId(professionalId);
            int count = courseService.addCourse(course);
            if(count>0){
                return DtoUtil.returnSuccess("增加成功！");
            }else {
                return DtoUtil.returnFail("添加失败！","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "修改科目", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "修改科目： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 修改科目失败 </p>" +
            "<p>0 : 修改科目成功 </p>" )
    @RequestMapping(value = "/updateCourse",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> updateCourse(Course course,Integer professionalId){

        course.getProfessional().setId(professionalId);

        try {
            int count = courseService.updateCourse(course);
            if(count>0){
                return DtoUtil.returnSuccess("修改成功！");
            }else {
                return DtoUtil.returnFail("修改失败","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }




    @ApiOperation(value = "删除科目", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "删除科目 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除科目失败 </p>" +
            "<p>0 : 删除科目成功 </p>" )
    @RequestMapping(value = "/deleteCourse",method = RequestMethod.GET)
    public Dto<Object> deleteCourse(String id){
        try {
            int count = courseService.deleteCourse(Integer.valueOf(id));
            if(count>0){
                return DtoUtil.returnSuccess("删除成功！");
            }else {
                return DtoUtil.returnFail("删除失败！","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "查询所有科目", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "查询所有科目 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除科目失败 </p>" +
            "<p>0 : 删除科目成功 </p>" )
    @RequestMapping(value = "/getAllCourse",method = RequestMethod.GET)
    public ResultMsg getAllCourse(){
        try {
            List<Course> list = courseService.getCourse();
            if(list.size()>0){
                return ResultMsg.BY_SUCCESS("查询成功", list);
            }else {
                return ResultMsg.BY_FAIL("查询失败");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @ApiOperation(value = "根据专业查询科目", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "根据专业查询科目 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 查询科目失败 </p>" +
            "<p>0 : 查询科目成功 </p>" )
    @RequestMapping(value = "/getCourseByProfessionalId",method = RequestMethod.GET)
    public ResultMsg getCourseByProfessionalId(Integer professionalId){
        try {
            List<Course> list = courseService.getCourseByProfessionalId(professionalId);
            if(list != null){
                return ResultMsg.BY_SUCCESS("查询成功", list);
            }else {
                return ResultMsg.BY_FAIL("查询失败");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }
}
