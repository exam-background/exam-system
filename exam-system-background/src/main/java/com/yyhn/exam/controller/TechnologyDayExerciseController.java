package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.service.TechnologyDayExerciseService;
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
@Api( value = "针对技术每日一练进行维护",description = "技术每日一练控制器类")
public class TechnologyDayExerciseController {

    @Resource
    private TechnologyDayExerciseService technologyDayExerciseService;


    @ApiOperation(value = "查询所有技术每日一练信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "根据条件查询技术每日一练信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/technologyDayExerciseForPage",method = RequestMethod.GET)
    public Dto<List<JobDayExercise>> getAllTechnologyDayExercise(
            String title,
            String types,
            Integer profesionalId,
            Integer courseId,
            @RequestParam(defaultValue = "2")
                    String pageSize,
            @RequestParam(defaultValue = "1")
                    Integer currentPage){
        Page<List<TechnologyDayExercise>> page = new Page<List<TechnologyDayExercise>>();
        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            technologyDayExerciseService.getAllTechnologyDayExercise(title,types,profesionalId,courseId,page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }

    @ApiOperation(value = "增加技术每日一练信息", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加技术每日一练信息 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加技术每日一练信息失败 </p>" +
            "<p>0 : 添加技术每日一练信息成功 </p>" )
    @RequestMapping(value = "/addTechnologyDayExercise",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> addTechnologyDayExercise(TechnologyDayExercise technologyDayExercise,Integer professionalId,Integer courseId){

        try {
            technologyDayExercise.getProfessional().setId(professionalId);
            technologyDayExercise.getCourse().setId(courseId);

            int count = technologyDayExerciseService.addTechnologyDayExercise(technologyDayExercise);
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



}
