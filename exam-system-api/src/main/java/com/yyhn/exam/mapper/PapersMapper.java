package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.Papers;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PapersMapper extends BaseMapper<Papers> {
    /**
     * 条件查询试卷
     * @param papers
     * @return
     */
    List<Papers> getPapersAll(Papers papers);
}
