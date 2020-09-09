package com.yyhn.exam.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.mapper.AppPapersUserMapper;
import com.yyhn.exam.mapper.PapersUserMapper;
import com.yyhn.exam.service.AppPapersUserService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class AppPapersUserServiceImpl implements AppPapersUserService {
    @Resource
    private PapersUserMapper papersUserMapper;
    @Resource
    private AppPapersUserMapper appPapersUserMapper;

    @Override
    public List<PapersUser> getPapersUserByUserId(Integer id) {
        return papersUserMapper.getPapersUserByUserId(id);
    }

    @Override
    public int updateIsPapers(Integer userId, Integer papersId) {
        return appPapersUserMapper.updatePapersByUserIdAndPapersId(userId, papersId);
    }
}
