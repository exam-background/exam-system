package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.service.PapersTitleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对试卷题目进行维护",description = "试卷管理题目控制器类")
public class PapersTitleController {
    @Resource
    private PapersTitleService papersTitleService;

    @ApiOperation(value = "根据试卷id查询试卷题目", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据试卷id查询试卷题目")
    @GetMapping("/getPapersTitleByPapersId")
    public ResultMsg getPapersTitleByPapersId(Integer id){
        List<PapersTitle> papersTitleList = papersTitleService.getPapersTitleByPapersId(id);
        if(papersTitleList != null){
            return ResultMsg.BY_SUCCESS("查询成功", papersTitleList);
        }else {
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
