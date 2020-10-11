package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.Class;
import com.yyhn.exam.entity.Student;
import com.yyhn.exam.mapper.AppClassMapper;
import com.yyhn.exam.service.AppClassService;
import com.yyhn.exam.vo.ClassCuoTiVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class AppClassServiceImpl implements AppClassService {
    @Resource
    private AppClassMapper mapper;
    @Override
    public List<Class> getBanClass(int id) {
        return mapper.getBanClass(id);
    }

    @Override
    public List<Class> getJiaoClass(int id) {
        return mapper.getJiaoClass(id);
    }

    @Override
    public List<Student> getStudentListByClassId(int id) {
        return mapper.getStudentListByClassId(id);
    }

    @Override
    public List<ClassCuoTiVo> getCuoTiCount(int id) {
        return null;
    }
}
