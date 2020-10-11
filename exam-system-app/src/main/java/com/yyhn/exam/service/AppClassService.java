package com.yyhn.exam.service;

import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.vo.ClassCuoTiVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AppClassService {
    List<Class> getBanClass(int id);

    List<Class> getJiaoClass(int id);
    List<Student> getStudentListByClassId(int id);

    List<ClassCuoTiVo> getCuoTiCount(int id);
}

