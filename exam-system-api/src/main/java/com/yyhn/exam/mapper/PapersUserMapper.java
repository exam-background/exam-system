package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.PapersUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PapersUserMapper extends BaseMapper<PapersUser> {
    /**
     * 根据试卷id查询考试学生
     * @param id
     * @return
     */
    List<PapersUser> getPapersUserByPapersId(Integer id);
}
