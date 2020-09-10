package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.PapersUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AppPapersUserMapper extends BaseMapper<PapersUser> {
    /**
     * 根据用户名和试卷id修改试卷
     * @param userId
     * @param papersId
     * @return
     */
    int updatePapersByUserIdAndPapersId(@Param("userId")Integer userId, @Param("papersId")Integer papersId);
}
