package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersUser;
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

}
