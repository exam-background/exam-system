package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.service.AppPapersUserService;
import com.yyhn.exam.service.PapersUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/app/PapersController")
public class AppPapersController {
    @Resource
    private AppPapersUserService appPapersUserService;

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
