package com.yyhn.exam.controller;

import com.yyhn.exam.dto.ResultMsg;
import com.yyhn.exam.service.StudentCuoTiService;
import com.yyhn.exam.vo.TechnologyDayExerciseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.transform.Result;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AppStudentCuoTiController {
    @Autowired
    StudentCuoTiService studentCuoTiService;
    @GetMapping("/cuoti/meiriyilian")
    public ResultMsg getMeiRiYiLian(int studentId) {
        List<TechnologyDayExerciseVO> vos = new ArrayList<>();
        vos.addAll(studentCuoTiService.getJianDa(studentId));
        vos.addAll(studentCuoTiService.getXuanZe(studentId));
        return ResultMsg.BY_SUCCESS("成功",vos);
    }

    @GetMapping("/cuoti/job")
    public ResultMsg getJobCuoTi(int studentId){
        return ResultMsg.BY_SUCCESS("成功",studentCuoTiService.getJobCuoTi(studentId));
    }

    @GetMapping("/cuoti/shijuan")
    public ResultMsg getShiJuan(int studentId){
        return ResultMsg.BY_SUCCESS("成功",studentCuoTiService.getPaperJianDa(studentId));
    }

    @GetMapping("/getJiShuCount")
    public ResultMsg getJobCount(Integer id){
        return ResultMsg.BY_SUCCESS("成功",studentCuoTiService.getCuoTiCount(id));
    }
}
