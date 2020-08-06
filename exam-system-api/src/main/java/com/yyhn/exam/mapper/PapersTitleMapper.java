package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.PapersTitle;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PapersTitleMapper extends BaseMapper<PapersTitle> {
    /**
     * 根据试卷id查询试卷题目
     * @param id
     * @return
     */
    public List<PapersTitle> getPapersTitleByPapersId(Integer id);
}
