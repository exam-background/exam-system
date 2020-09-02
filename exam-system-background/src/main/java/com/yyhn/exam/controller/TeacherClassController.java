package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.TeacherClass;
import com.yyhn.exam.service.TeacherClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "对教师关联班级进行维护",description = "教师关联班级控制器类")
public class TeacherClassController {
    @Resource
    private TeacherClassService teacherClassService;

    @ApiOperation(value = "新增教师关联班级信息", httpMethod = "POST",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "新增教师关联班级信息")
    @PostMapping("/insertTeacherClass")
    public ResultMsg insertTeacherClass(TeacherClass teacherClasst){
        if(teacherClassService.insertTeacherClass(teacherClasst) > 0){
            return ResultMsg.BY_SUCCESS("增加成功", null);
        }else{
            return ResultMsg.BY_FAIL("增加失败");
        }
    }

    @ApiOperation(value = "修改教师关联班级", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "修改教师关联班级")
    @GetMapping("/updateTeacherClass")
    public ResultMsg updateTeacherClass(TeacherClass teacherClasst){
        System.out.println(teacherClasst+"-----");
        if(teacherClassService.updateTeacherClass(teacherClasst) > 0){
            return ResultMsg.BY_SUCCESS("修改成功", null);
        }else{
            return ResultMsg.BY_FAIL("修改失败");
        }
    }

    @ApiOperation(value = "删除教师关联班级", httpMethod = "DELETE",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "删除教师关联班级")
    @DeleteMapping("/deleteTeacherClass")
    public ResultMsg deleteTeacherClass(Integer id){
        if(teacherClassService.deleteTeacherClass(id) > 0){
            return ResultMsg.BY_SUCCESS("删除成功", null);
        }else{
            return ResultMsg.BY_FAIL("删除失败");
        }
    }

    @ApiOperation(value = "根据教师名称，专业查询教师关联班级", httpMethod = "GET",
            protocols = "HTTP",
            response = ResultMsg.class, notes = "根据教师名称，专业查询教师关联班级")
    @GetMapping("/selectTeacherClass")
    public ResultMsg selectTeacherClass(String teacherName, Integer professionalId){
        List<TeacherClass> list = teacherClassService.getTeacherClass(teacherName, professionalId);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

}
