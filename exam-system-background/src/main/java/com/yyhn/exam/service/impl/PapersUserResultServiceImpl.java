package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.mapper.PapersUserResultMapper;
import com.yyhn.exam.service.PapersUserResultService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PapersUserResultServiceImpl implements PapersUserResultService {

    @Resource
    private PapersUserResultMapper papersUserResultMapper;

    @Override
    @Transactional(propagation= Propagation.REQUIRED)
    public int deletePapersUserResult(Integer id) throws RuntimeException{
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("papers_id", id);
        System.out.println("考试题目增加完成");
        return papersUserResultMapper.deleteByMap(map);
    }

    @Override
    public int updatePapersUserResult(PapersUserResult papersUserResult) {
        return papersUserResultMapper.updateById(papersUserResult);
    }

    @Override
    public List<PapersUserResult> getPapersUserResultByUserId(Integer id, Integer papersId) {
        return papersUserResultMapper.getPapersUserResultByPapersId(id, papersId);
    }
}
