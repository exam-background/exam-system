package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.service.AppClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppClassController {
    @Autowired
    private AppClassService appClassService;

    @GetMapping("/getBanClass")
    public ResultMsg getBanClass(Integer id){
    System.out.println(id);
        List<Class> classes = appClassService.getBanClass(id);
        if(null == classes){
            return ResultMsg.BY_NULL("没有班级");
        }else{
            return ResultMsg.BY_SUCCESS("成功",classes);
        }
    }

    @GetMapping("/getJiaoClass")
    public ResultMsg getJiaoClass(Integer id){
        List<Class> classes = appClassService.getJiaoClass(id);

        if(null == classes){
            return ResultMsg.BY_NULL("没有班级");
        }else{
            return ResultMsg.BY_SUCCESS("成功",classes);
        }
    }
    @GetMapping("/getStudentByClassId")
    public ResultMsg getStudentByClassId(Integer id){
        List<Student> students = appClassService.getStudentListByClassId(id);
        if(null == students){
            return ResultMsg.BY_NULL("班级没有学生");
        }else{
            return ResultMsg.BY_SUCCESS("成功",students);
        }
    }
}
