package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Professional;
import com.yyhn.exam.service.ClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对班级信息进行维护",description = "班级管理控制器类")
public class ClassController {

    @Resource
    ClassService classService;

    @ApiOperation(value = "查询所有班级信息", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有班级信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/getAllClassNoPage",method = RequestMethod.GET)
    public Dto<Object> getAllClassNoPage(){
        try {
            List<Class> classList = classService.getAllClassNoPage();
            return DtoUtil.returnDataSuccess(classList);
        }catch (Exception ex){
            ex.printStackTrace();;
            return DtoUtil.returnFail("查询失败","100101");
        }
    }


    @ApiOperation(value = "根据条件查询班级信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "根据条件查询班级信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/classForPage",method = RequestMethod.GET)
    public Dto<List<Class>> classForPage(String grade,Integer classTeacherId,Integer professionalTeacherId,
                                                       @RequestParam(defaultValue = "2")
                                                               String pageSize,
                                                       @RequestParam(defaultValue = "1")
                                                               Integer currentPage){
        Page<List<Class>> page = new Page<List<Class>>();

        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            classService.getAllClass(grade,classTeacherId,professionalTeacherId,page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }


    @ApiOperation(value = "增加班级", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加班级 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加班级失败 </p>" +
            "<p>0 : 添加班级成功 </p>" )
    @RequestMapping(value = "/addClass",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> addClass( Class clazz,Integer classTeacherId,Integer professionalTeacherId){
        try {
            clazz.getClassTeacher().setId(classTeacherId);
            clazz.getProfessionalTeacher().setId(professionalTeacherId);

            System.out.println(" class : "+clazz);
            int count = classService.addClass(clazz);
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


    @ApiOperation(value = "修改班级", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "修改班级 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 修改班级失败 </p>" +
            "<p>0 : 修改班级成功 </p>" )
    @RequestMapping(value = "/updateClass",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> updateClass(Class clazz,Integer classTeacherId,Integer professionalTeacherId){

        clazz.getClassTeacher().setId(classTeacherId);
        clazz.getProfessionalTeacher().setId(professionalTeacherId);
        System.out.println("clazz : "+clazz);
        try {
            int count = classService.updateClass(clazz);
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


    @ApiOperation(value = "删除班级", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "删除班级 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除班级失败 </p>" +
            "<p>0 : 删除班级成功 </p>" )
    @RequestMapping(value = "/deleteClass",method = RequestMethod.GET)
    public Dto<Object> deleteClass(String id){
        return classService.deleteClass(Integer.valueOf(id));
    }


}
