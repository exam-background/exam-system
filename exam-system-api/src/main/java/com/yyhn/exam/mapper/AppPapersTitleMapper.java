package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.PapersTitle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AppPapersTitleMapper extends BaseMapper<PapersTitle> {
    /**
     * 根据学生作答的试卷id查询对应题目信息
     * @param id
     * @return
     */
    public List<PapersTitle> getPapersTitleByPapersid(Integer id);
}
