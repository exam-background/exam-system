package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.service.PapersUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对试卷考试学生进行维护",description = "试卷管理考试学生控制器类")
public class PapersUserController {
    @Resource
    private PapersUserService papersUserService;

    @ApiOperation(value = "根据试卷id查询试卷考试学生", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据试卷id查询试卷考试学生")
    @GetMapping("/getPapersUserByPapersId")
    public ResultMsg getPapersUserByPapersId(Integer id){
        List<PapersUser> papersUserList = papersUserService.getPapersUserByPapersId(id);
        if(papersUserList != null){
            return ResultMsg.BY_SUCCESS("查询成功", papersUserList);
        }else {
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

}
