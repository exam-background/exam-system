package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.service.PapersUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PapersUserController {
    @Resource
    private PapersUserService papersUserService;

    @RequestMapping("/getPapersUserByPapersId")
    public ResultMsg getPapersUserByPapersId(Integer id){
        List<PapersUser> papersUserList = papersUserService.getPapersUserByPapersId(id);
        if(papersUserList != null){
            return ResultMsg.BY_SUCCESS("查询成功", papersUserList);
        }else {
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

}
