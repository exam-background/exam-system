package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Teacher;
import com.yyhn.exam.service.AppStudentService;
import com.yyhn.exam.service.AppTeacherService;
import com.yyhn.exam.vo.StudentUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppStudentController {
    @Autowired
    private AppStudentService studentService;

    @Autowired
    private AppTeacherService appTeacherService;



    @GetMapping("/getStuById")
    public ResultMsg getStuById(int id) {

        StudentUserVo vo = studentService.getStuById(id);
        return  ResultMsg.BY_SUCCESS("获取成功",vo);
    }

    @GetMapping("/getTeacherById")
    public ResultMsg getTeacherById(int id) {
        Teacher vo = appTeacherService.getTeacherById(id);
        return  ResultMsg.BY_SUCCESS("获取成功",vo);
    }


}
