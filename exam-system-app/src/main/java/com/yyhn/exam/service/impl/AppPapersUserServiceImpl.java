package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.mapper.PapersUserMapper;
import com.yyhn.exam.service.AppPapersUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppPapersUserServiceImpl implements AppPapersUserService {
    @Resource
    private PapersUserMapper papersUserMapper;

    @Override
    public List<PapersUser> getPapersUserByUserId(Integer id) {
        return papersUserMapper.getPapersUserByUserId(id);
    }
}
