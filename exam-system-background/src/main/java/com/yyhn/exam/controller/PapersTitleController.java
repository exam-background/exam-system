package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.service.PapersTitleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PapersTitleController {
    @Resource
    private PapersTitleService papersTitleService;

    @RequestMapping("/getPapersTitleByPapersId")
    public ResultMsg getPapersTitleByPapersId(Integer id){
        List<PapersTitle> papersTitleList = papersTitleService.getPapersTitleByPapersId(id);
        if(papersTitleList != null){
            return ResultMsg.BY_SUCCESS("查询成功", papersTitleList);
        }else {
            return ResultMsg.BY_FAIL("查询失败");
        }
    }
}
