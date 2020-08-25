package com.yyhn.exam.service.impl;

import com.yyhn.exam.entity.PapersTitle;
import com.yyhn.exam.mapper.AppPapersTitleMapper;
import com.yyhn.exam.service.AppPapersTitleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AppPapersTitleServiceImpl implements AppPapersTitleService {
    @Resource
    private AppPapersTitleMapper appPapersTitleMapper;

    @Override
    public List<PapersTitle> getPapersTitleByPapersid(Integer id) {
        return appPapersTitleMapper.getPapersTitleByPapersid(id);
    }
}
