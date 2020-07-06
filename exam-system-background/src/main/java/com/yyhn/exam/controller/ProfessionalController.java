package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Professional;
import com.yyhn.exam.service.ProfessionalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api( value = "针对专业信息进行维护",description = "专业管理控制器类")
public class ProfessionalController {

    @Autowired
    private ProfessionalService professionalService;

    @ApiOperation(value = "查询所有专业信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有专业信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/professionalForPage",method = RequestMethod.GET)
    public Dto<List<Professional>> professionalForPage(String pname,
                                                    @RequestParam(defaultValue = "2")
                                                            String pageSize,
                                                    @RequestParam(defaultValue = "1")
                                                            Integer currentPage){
        Page<List<Professional>> page = new Page<List<Professional>>();
        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            professionalService.getProfessional(pname,page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }

    @ApiOperation(value = "查询所有专业信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有专业信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/professionalList",method = RequestMethod.GET)
    public Dto<Object> professionalList(String pname,
                                                    @RequestParam(defaultValue = "2")
                                                    String pageSize,
                                                    @RequestParam(defaultValue = "1")
                                                    Integer currentPage){
        List<Professional> professionalList = null;
        System.out.println("pageSize : "+pageSize +"\t currentPage : "+currentPage);
        try {
            professionalList = professionalService.getAllProfessional(pname,Integer.valueOf(pageSize),Integer.valueOf(currentPage));
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(professionalList);
    }

    @ApiOperation(value = "查询所有专业信息，不分页处理", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有专业信息，不分页处理" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/getProfessionalNoPage",method = RequestMethod.GET)
    public Dto<Object> getProfessionalNoPage(){
        List<Professional> professionalList = null;
        try {
            professionalList = professionalService.getProfessionalNoPage();
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(professionalList);
    }




    @ApiOperation(value = "增加专业", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加专业 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加专业失败 </p>" +
            "<p>0 : 添加专业成功 </p>" )
    @RequestMapping(value = "/addProfessional",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> addProfessional(Professional professional){
        try {
            int count = professionalService.addProfessional(professional);
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



    @ApiOperation(value = "修改专业", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "修改专业 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 修改专业失败 </p>" +
            "<p>0 : 修改专业成功 </p>" )
    @RequestMapping(value = "/updateProfessional",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> updateProfessional(Professional professional){
        try {
            int count = professionalService.updateProfessional(professional);
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






    @ApiOperation(value = "删除专业", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "删除专业 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除专业失败 </p>" +
            "<p>0 : 删除专业成功 </p>" )
    @RequestMapping(value = "/deleteProfessional",method = RequestMethod.GET)
    public Dto<Object> deleteProfessional(String id){
        try {
            int count = professionalService.deleteProfessional(Integer.valueOf(id));
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



}
