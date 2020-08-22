package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.PapersUserResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PapersUserResultMapper extends BaseMapper<PapersUserResult> {
    /**
     * 根据试卷id查询考试学生
     * @param id
     * @return
     */
    public List<PapersUserResult> getPapersUserResultByPapersId(@Param("id") Integer id,@Param("papersId") Integer papersId);
}
