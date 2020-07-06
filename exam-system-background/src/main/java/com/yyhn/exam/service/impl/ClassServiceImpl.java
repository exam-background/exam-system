package com.yyhn.exam.service.impl;

import com.yyhn.exam.common.Dto;
import com.yyhn.exam.common.DtoUtil;
import com.yyhn.exam.common.Page;
import com.yyhn.exam.entity.Course;
import com.yyhn.exam.mapper.ClassMapper;
import com.yyhn.exam.service.ClassService;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.yyhn.exam.entity.Class;
import org.springframework.stereotype.Service;

@Service
public class ClassServiceImpl implements ClassService {

    @Resource
    private ClassMapper classMapper;

    @Override
    public List<Class> getAllClassNoPage() {
        List<Class> classList = classMapper.getAllClassNoPage();
        return classList;
    }

    @Override
    public void getAllClass(String grade,Integer classTeacherId,Integer professionalTeacherId, Page<List<Class>> page) {
        Map<String,Object> map = new HashMap<>();
        map.put("grade",grade);
        map.put("classTeacherId",classTeacherId);
        map.put("professionalTeacherId",professionalTeacherId);
        map.put("startRow",(page.getCurPage()-1)*page.getPageSize());
        map.put("pageSize",page.getPageSize());
        //根据条件查询课程信息
        List<Class> courseList = classMapper.getAllClass(map);
        int total = classMapper.getCount(map);
        page.setData(courseList);
        page.setTotal(total);
    }

    @Override
    public int addClass(Class clazz) {
        return classMapper.addClass(clazz);
    }

    @Override
    public int updateClass(Class clazz) {
        return classMapper.updateClass(clazz);
    }

    @Override
    public Dto<Object> deleteClass(int id) {
         // 根据班级ID 检查该班级下是否存在学生
         int stucount = classMapper.checkClassInStudent(id);
         if(stucount>0){
             return DtoUtil.returnFail("删除失败,请确保该班级下没有学生，","100101");
         }else {
             int count = classMapper.deleteClass(id);
             if(count >0 ){
                 return DtoUtil.returnSuccess();
             }else{
                 return DtoUtil.returnFail("删除失败，","100101");
             }
         }
    }
}
