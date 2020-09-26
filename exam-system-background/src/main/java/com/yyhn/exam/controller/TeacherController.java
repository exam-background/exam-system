package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Teacher;
import com.yyhn.exam.service.TeacherService;
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
@Api( value = "针对老师信息进行维护",description = "老师管理控制器类")

public class TeacherController {
    @Resource
    TeacherService teacherService;

    @ApiOperation(value = "查询所有老师信息", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有老师信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/getAllTeacherNoPage",method = RequestMethod.GET)
    public Dto<Object> getAllTeacherNoPage(String positionName){
        try {
            List<Teacher> classList = teacherService.getAllTeacherNoPage(positionName);
            return DtoUtil.returnDataSuccess(classList);
        }catch (Exception ex){
            ex.printStackTrace();;
            return DtoUtil.returnFail("查询失败","100101");
        }
    }


    @ApiOperation(value = "查询所有老师信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有老师信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/teacherForPage",method = RequestMethod.GET)
    public Dto<List<Teacher>> teacherForPage(String teacherName,
                                              Integer professionalId,
                                         @RequestParam(defaultValue = "2")
                                                 String pageSize,
                                         @RequestParam(defaultValue = "1")
                                                 Integer currentPage){
        Page<List<Teacher>> page = new Page<List<Teacher>>();
        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            teacherService.getAllTeacher(teacherName,professionalId,page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }


    @ApiOperation(value = "增加老师信息", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加老师 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加老师失败 </p>" +
            "<p>0 : 添加老师成功 </p>" )
    @RequestMapping(value = "/addTeacher",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> addTeacher(Teacher teacher,Integer professionalId){
        teacher.getProfessional().setId(professionalId);
        try {
            System.out.println(" class : "+teacher);
            int count = teacherService.addTeacher(teacher);
            if(count>0){
                return DtoUtil.returnSuccess("添加成功！");
            }else {
                return DtoUtil.returnFail("添加失败！","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "修改老师信息", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "修改老师 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 修改老师失败 </p>" +
            "<p>0 : 修改老师成功 </p>" )
    @RequestMapping(value = "/updateTeacher",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> updateTeacher(Teacher teacher,Integer professionalId){
        teacher.getProfessional().setId(professionalId);
        try {
            int count = teacherService.updateTeacher(teacher);
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


    @ApiOperation(value = "删除老师信息", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "删除老师信息 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除老师失败 </p>" +
            "<p>0 : 删除老师成功 </p>" )
    @RequestMapping(value = "/deleteTeacher",method = RequestMethod.GET)
    public Dto<Object> deleteTeacher(String id){
        try {
            int count = teacherService.deleteTeacher(Integer.valueOf(id));
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
}
