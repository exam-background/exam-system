package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Papers;
import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.service.AppPapersService;
import com.yyhn.exam.service.AppPapersUserService;
import com.yyhn.exam.service.PapersUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/PapersController")
@Api( value = "针对手机端试卷进行维护",description = "手机端试卷控制器类")
public class AppPapersController {
    @Resource
    private AppPapersUserService appPapersUserService;
    @Resource
    private AppPapersService appPapersService;

    @ApiOperation(value = "手机端根据用户id拿到试卷信息", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据用户id拿到试卷信息")
    @GetMapping("/getPapersUserByUserId")
    public ResultMsg getPapersUserByUserId(Integer id){
        List<PapersUser> list = appPapersUserService.getPapersUserByUserId(id);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @ApiOperation(value = "根据用户id和试卷类型查询待考试卷", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据用户id和试卷类型查询待考试卷")
    @GetMapping("/getPapersByUserIdAndType")
    public ResultMsg getPapersByUserIdAndType(Integer userId, Integer type){
        List<Papers> list = appPapersService.getPapersByUserIdAndtype(userId, type);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @ApiOperation(value = "根据用户id和试卷类型查询已考试卷", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据用户id和试卷类型查询已考试卷")
    @GetMapping("/getPapersByUserIdAndTypeFinish")
    public ResultMsg getPapersByUserIdAndTypeFinish(Integer userId, Integer type){
        List<Papers> list = appPapersService.getPapersByUserIdAndtypeFinish(userId, type);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @ApiOperation(value = "根据试卷id查询试卷", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据试卷id查询试卷")
    @GetMapping("/getPapersById")
    public ResultMsg getPapersById(Integer id){
        Papers papers = appPapersService.getPapersById(id);
        if(papers != null){
            return ResultMsg.BY_SUCCESS("查询成功", papers);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

    @ApiOperation(value = "根据试卷id查询试卷和学生作答", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据试卷id查询试卷和学生作答")
    @GetMapping("/getPapersByIdStudent")
    public ResultMsg getPapersByIdStudent(Integer id){
        Papers papers = appPapersService.getPapersByIdStudent(id);
        if(papers != null){
            return ResultMsg.BY_SUCCESS("查询成功", papers);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
