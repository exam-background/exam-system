package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.mapper.PapersUserMapper;
import com.yyhn.exam.service.PapersUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PapersUserServiceImpl implements PapersUserService {
    @Resource
    private PapersUserMapper papersUserMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void deletePapersUser(Integer id)  throws RuntimeException{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("papers_id", id);
        if(papersUserMapper.deleteByMap(map) < 0){
            throw new RuntimeException("试卷考试学生删除失败");
        }
    }

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public void insertPapersUser(PapersUser papersUser)  throws RuntimeException{
        if(papersUserMapper.insert(papersUser) <= 0){
            throw new RuntimeException("试卷考试学生新增失败");
        }
        System.out.println("考试学生增加完成");
    }

    @Override
    public List<PapersUser> getPapersUserByPapersId(Integer id) {
        return papersUserMapper.getPapersUserByPapersId(id);
    }
}
