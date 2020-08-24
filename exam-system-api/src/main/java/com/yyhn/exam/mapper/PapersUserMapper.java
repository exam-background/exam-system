package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.PapersUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PapersUserMapper extends BaseMapper<PapersUser> {
    /**
     * 根据试卷id查询考试学生
     * @param id
     * @return
     */
    List<PapersUser> getPapersUserByPapersId(Integer id);
    /**
     * 根据试学生id查询试卷信息
     * @param id
     * @return
     */
    List<PapersUser> getPapersUserByUserId(@Param("id") int id);
}
