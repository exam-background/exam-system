package com.yyhn.exam.controller;

import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.service.AppTechnologyDayExerciseItemService;
import com.yyhn.exam.service.AppTechnologyDayExerciseSubmitService;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/app/TechnologyDayExerciseSubmitController")
public class AppTechnologyDayExerciseSubmitController {
    @Resource
    private AppTechnologyDayExerciseSubmitService appTechnologyDayExerciseSubmitService;
    @Resource
    private AppTechnologyDayExerciseItemService appTechnologyDayExerciseItemService;

    @PostMapping("/addTechnologyDayExerciseSubmit")
    public ResultMsg addTechnologyDayExerciseSubmit(TechnologyDayExerciseSubmit technologyDayExerciseSubmit){
        if(appTechnologyDayExerciseSubmitService.addTechnologyDayExerciseSubmit(technologyDayExerciseSubmit) > 0){
            return ResultMsg.BY_SUCCESS("添加成功", null);
        }else{
            return ResultMsg.BY_FAIL("添加失败");
        }
    }

    @GetMapping("/getTechnologyDayExerciseSubmitByUserId")
    public ResultMsg getTechnologyDayExerciseSubmitByUserId(Integer id){
        List<TechnologyDayExerciseSubmit> list = appTechnologyDayExerciseSubmitService.getTechnologyDayExerciseSubmitByUserId(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @GetMapping("/getTechnologyDayExerciseSubmitByRight")
    public ResultMsg getTechnologyDayExerciseSubmitByRight(Integer id){
        List<TechnologyDayExerciseSubmit> list = appTechnologyDayExerciseSubmitService.getTechnologyDayExerciseSubmitByRight(id);
        if(list != null){
            //判断是否为选择题，如果为选择题则查询选择题选项
            List<TechnologyDayExerciseSubmit> listAll = new ArrayList<TechnologyDayExerciseSubmit>();
            for(TechnologyDayExerciseSubmit technologyDayExerciseSubmit : list) {
                if(Integer.parseInt(technologyDayExerciseSubmit.getTechnologyDayExercise().getTypes()) == 2){
                    //根据题目id查询题目选择题
                    technologyDayExerciseSubmit.getTechnologyDayExercise().setExerciseItems(appTechnologyDayExerciseItemService.getTechnologyDayExerciseByExerciseId(technologyDayExerciseSubmit.getTechnologyDayExercise().getId()));
                }
                listAll.add(technologyDayExerciseSubmit);
            }
            return ResultMsg.BY_SUCCESS("查询成功", listAll);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
