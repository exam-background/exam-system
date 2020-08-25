package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersUserResult;
import com.yyhn.exam.mapper.AppPapersUserResultMapper;
import com.yyhn.exam.service.AppPapersUserResultService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppPapersUserResultServiceImpl implements AppPapersUserResultService {
    @Resource
    private AppPapersUserResultMapper appPapersUserResultMapper;

    @Override
    public List<PapersUserResult> getPapersUserResultByRight(Integer papersId, Integer userid) {
        return appPapersUserResultMapper.getPapersUserResultByRight(papersId, userid);
    }

    @Override
    public int insertPapersUserResult(PapersUserResult papersUserResult) {
        return appPapersUserResultMapper.insert(papersUserResult);
    }

    @Override
    public int updatePapersUserResult(PapersUserResult papersUserResult) {
        return appPapersUserResultMapper.updateById(papersUserResult);
    }
}
