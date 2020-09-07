package com.yyhn.exam.controller;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.service.ClassService;
import com.yyhn.exam.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api( value = "针对学生信息进行维护",description = "学生管理控制器类")
public class StudentController {

     @Resource
     private StudentService studentService;

    @ApiOperation(value = "查询所有学生信息", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有学生信息" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/getAllStudentNoPage",method = RequestMethod.GET)
    public Dto<Object> getAllStudentNoPage(){
        try {
            List<Student> classList = studentService.getAllStudentNoPage();
            return DtoUtil.returnDataSuccess(classList);
        }catch (Exception ex){
            ex.printStackTrace();;
            return DtoUtil.returnFail("查询失败","100101");
        }
    }


    @ApiOperation(value = "查询所有学生信息，并分页显示", httpMethod = "GET",
            protocols = "HTTP",
            response = Dto.class, notes = "查询所有学生信息，并分页显示" +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>100101 : 查询失败 </p>" +
            "<p>0 : 查询成功 </p>" )
    @RequestMapping(value = "/studentForPage",method = RequestMethod.GET)
    public Dto<List<Student>> studentForPage(String stuName,
                                              Integer professionalId,
                                              Integer classId,
                                         @RequestParam(defaultValue = "2")
                                                 String pageSize,
                                         @RequestParam(defaultValue = "1")
                                                 Integer currentPage){
        Page<List<Student>> page = new Page<List<Student>>();
        try {
            page.setPageSize(Integer.valueOf(pageSize));
            page.setCurPage(currentPage);
            studentService.getAllStudent(professionalId,classId,stuName,page);
        }catch (Exception ex){
            ex.printStackTrace();;
            DtoUtil.returnFail("查询失败！","100101");
        }
        return  DtoUtil.returnDataSuccess(page);
    }


    @ApiOperation(value = "增加学生", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "增加学生 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 添加学生失败 </p>" +
            "<p>0 : 添加学生成功 </p>" )
    @RequestMapping(value = "/addStudent",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> addStudent(Student student){
        try {
            System.out.println(" student : "+student.toString());
            int count = studentService.addStudent(student);
            if(count>0){
                return DtoUtil.returnSuccess("添加成功！");
            }else {
                return DtoUtil.returnFail("添加失败！","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "修改学生", httpMethod = "POST",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "修改学生 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 修改学生失败 </p>" +
            "<p>0 : 修改学生成功 </p>" )
    @RequestMapping(value = "/updateStudent",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = {MediaType.APPLICATION_ATOM_XML_VALUE, MediaType.APPLICATION_JSON_VALUE,})
    public Dto<Object> updateStudent(Student student,Integer professionalId,Integer classId){
        System.out.println(student.toString()+":"+professionalId+":"+classId);
        try {
            student.getClazz().setId(classId);
            student.getProfessional().setId(professionalId);
            int count = studentService.updateStudent(student);
            if(count>0){
                return DtoUtil.returnSuccess("修改成功！");
            }else {
                return DtoUtil.returnFail("修改失败！","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }


    @ApiOperation(value = "删除班级", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "删除班级 ： " +
            "<p>成功：success = ‘true’ | 失败：success = ‘false’ 并返回错误码，如下：</p>" +
            "<p>错误码：</p>" +
            "<p>100101 : 删除班级失败 </p>" +
            "<p>0 : 删除班级成功 </p>" )
    @RequestMapping(value = "/deleteStudent",method = RequestMethod.GET)
    public Dto<Object> deleteStudent(String id){
        try {
            int count = studentService.deleteStudent(Integer.valueOf(id));
            if(count>0){
                return DtoUtil.returnSuccess("删除成功！");
            }else {
                return DtoUtil.returnFail("删除失败！","100101");
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @GetMapping("/selectStudent")
    @ApiOperation(value = "根据班级id查询学生信息", httpMethod = "GET",
            protocols = "HTTP", produces = "application/json",
            response = Dto.class, notes = "根据班级id查询学生信息")
    public ResultMsg selectStudent(Integer classId){
        System.out.println(classId+"=======================");
        List<Student> list = studentService.selectStudent(classId);
        if(list != null){
            return ResultMsg.BY_SUCCESS("查询成功", list);
        }else{
            return ResultMsg.BY_FAIL("查询失败");
        }
    }

}
