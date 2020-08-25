package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.Papers;
import com.yyhn.exam.entity.PapersUserResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppPapersUserResultMapper extends BaseMapper<PapersUserResult> {
    /**
     * 根据试卷id和学生id查询错题
     * @param papersId
     * @param userid
     * @return
     */
    public List<PapersUserResult> getPapersUserResultByRight(@Param("papersId") Integer papersId, @Param("userid") Integer userid);
}
