package com.yyhn.exam.service.impl;

import com.yyhn.exam.mapper.JobCuoTiMapper;
import com.yyhn.exam.mapper.PaperCuoTiMapper;
import com.yyhn.exam.mapper.StudentCuoTiMapper;
import com.yyhn.exam.service.StudentCuoTiService;
import com.yyhn.exam.vo.ClassCuoTiVo;
import com.yyhn.exam.vo.TechnologyDayExerciseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentCuoTiServiceImpl implements StudentCuoTiService {
    @Resource
    private StudentCuoTiMapper mapper;
    @Resource
    private JobCuoTiMapper cuoTiMapper;

    @Resource
    private PaperCuoTiMapper paperCuoTiMapper;
    @Override
    public List<TechnologyDayExerciseVO> getJianDa(int studentId) {

        return mapper.getJianDa(studentId);
    }

    @Override
    public List<TechnologyDayExerciseVO> getXuanZe(int studentId) {
        List<TechnologyDayExerciseVO> vos = mapper.getXuanZe(studentId);
        for(TechnologyDayExerciseVO vo : vos){
            String items = vo.getItems();
            System.out.println(items);
           String [] xuan =  items.split("---");
           System.out.println(xuan);
            vo.setXuan(xuan);
        }
        return vos;
    }

    @Override
    public List<TechnologyDayExerciseVO> getJobCuoTi(int studentId) {
        return cuoTiMapper.getJobCuoTi(studentId);
    }

    @Override
    public List<TechnologyDayExerciseVO> getPaperJianDa(int studentId) {
        return paperCuoTiMapper.getJianDa(studentId);
    }

    @Override
    public List<ClassCuoTiVo> getCuoTiCount(int id) {
        return paperCuoTiMapper.getCuoTiCount(id);
    }
}
