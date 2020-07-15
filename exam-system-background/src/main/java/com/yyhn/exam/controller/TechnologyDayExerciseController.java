package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.JobDayExercise;
import com.yyhn.exam.entity.SysUser;
import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseItem;
import com.yyhn.exam.service.TechnologyDayExerciseItemService;
import com.yyhn.exam.service.TechnologyDayExerciseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对技术每日一练进行维护",description = "技术每日一练控制器类")
public class TechnologyDayExerciseController {

    @Resource
    private TechnologyDayExerciseService technologyDayExerciseService;
    @Resource
    private TechnologyDayExerciseItemService technologyDayExerciseItemService;

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

    @ApiOperation(value = "查询所有技术每日一练信息", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "根据条件查询技术每日一练信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/getTechnologyDayExercise",method = RequestMethod.POST)
    public ResultMsg getTechnologyDayExercise(String title, String types, Integer profesionalId, Integer courseId){
        System.out.println(title+":"+types+":"+profesionalId+":"+courseId);
        List<TechnologyDayExercise> list = technologyDayExerciseService.getTechnologyDayExercise(title,types,profesionalId,courseId);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
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

    @ApiOperation(value = "增加每日一练", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "增加每日一练" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/insertTechnologyDayExercise",method = RequestMethod.POST)
    @Transactional(propagation= Propagation.SUPPORTS)
    public ResultMsg insertTechnologyDayExercise(TechnologyDayExercise technologyDayExercise){
        try {
            if (technologyDayExercise.getTypes().equals("2")) {
                Integer redio = technologyDayExercise.getRadio();
                System.out.println(technologyDayExercise);
                switch (redio) {
                    case 1:
                        technologyDayExercise.setStandardAnswer(technologyDayExercise.getRedioItem()[0]);
                        break;
                    case 2:
                        technologyDayExercise.setStandardAnswer(technologyDayExercise.getRedioItem()[1]);
                        break;
                    case 3:
                        technologyDayExercise.setStandardAnswer(technologyDayExercise.getRedioItem()[2]);
                        break;
                    case 4:
                        technologyDayExercise.setStandardAnswer(technologyDayExercise.getRedioItem()[3]);
                        break;
                }
                if (technologyDayExerciseService.insertTechnologyDayExercise(technologyDayExercise) > 0) {
                    TechnologyDayExerciseItem technologyDayExerciseItem = null;

                    String[] num = {"A", "B", "C", "D"};
                    int a = 0;

                    for (String content : technologyDayExercise.getRedioItem()) {
                        technologyDayExerciseItem = new TechnologyDayExerciseItem();
                        technologyDayExerciseItem.setExerciseId(technologyDayExercise.getId());

                        technologyDayExerciseItem.setContent(content);
                        technologyDayExerciseItem.setOrderNum(num[a]);

                        if(technologyDayExerciseItemService.addTechnologyDayExerciseItem(technologyDayExerciseItem) <= 0){
                            throw new RuntimeException("选择题添加失败");
                        }
                        a++;
                    }
                } else {
                    throw new RuntimeException("题目添加失败");
                }
            } else {
                if (technologyDayExerciseService.insertTechnologyDayExercise(technologyDayExercise) > 0) {
                    System.out.println(technologyDayExercise.getId());
                    return ResultMsg.BY_SUCCESS("增加成功", null);
                } else {
                    return ResultMsg.BY_FAIL("增加失败");
                }
            }
        }catch (RuntimeException re) {
            return ResultMsg.BY_FAIL(re.getMessage());
        }
        return null;
    }

    @ApiOperation(value = "修改每日一练", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "修改每日一练" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/updateTechnologyDayExercise",method = RequestMethod.POST)
    public ResultMsg updateTechnologyDayExercise(TechnologyDayExercise technologyDayExercise){
        if(technologyDayExerciseService.updateTechnologyDayExercise(technologyDayExercise) > 0){
            return ResultMsg.BY_SUCCESS("修改成功", null);
        }else{
            return ResultMsg.BY_FAIL("修改失败");
        }
    }

    @ApiOperation(value = "删除每日一练", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "删除每日一练" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/deleteTechnologyDayExercise",method = RequestMethod.POST)
    public ResultMsg deleteTechnologyDayExercise(Integer id){
        if(technologyDayExerciseService.deleteTechnologyDayExercise(id) > 0){
            return ResultMsg.BY_SUCCESS("删除成功", null);
        }else{
            return ResultMsg.BY_FAIL("删除成功");
        }
    }

    @ApiOperation(value = "批量删除用户信息", httpMethod = "POST",
            protocols = "HTTP",
            response = Dto.class, notes = "修改用户信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/deleteTechnologyDayExercises",method = RequestMethod.POST)
    public Object deleteTechnologyDayExercises(@RequestBody List<TechnologyDayExercise> list){
        if(technologyDayExerciseService.deleteTechnologyDayExercises(list)>0){
            return ResultMsg.BY_SUCCESS("批量删除成功", null);
        }else{
            return ResultMsg.BY_FAIL("批量失败");
        }
    }


}
