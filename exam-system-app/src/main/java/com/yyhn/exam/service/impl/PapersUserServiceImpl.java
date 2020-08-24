package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersUser;
import com.yyhn.exam.mapper.PapersUserMapper;
import com.yyhn.exam.service.PapersUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PapersUserServiceImpl implements PapersUserService {
    @Resource
    private PapersUserMapper papersUserMapper;

    @Override
    public List<PapersUser> getPapersUserByUserId(Integer id) {
        return papersUserMapper.getPapersUserByUserId(id);
    }
}
