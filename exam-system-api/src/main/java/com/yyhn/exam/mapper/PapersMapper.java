package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.Papers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PapersMapper extends BaseMapper<Papers> {
    /**
     * 条件查询试卷
     * @param papers
     * @return
     */
    List<Papers> getPapersAll(Papers papers);

    /**
     * 条件查询已发布试卷
     * @param papers
     * @return
     */
    List<Papers> getPapersAllPublish(Papers papers);

    /**
     * 根据用户id和试卷类型查询已考试卷
     * @param userId
     * @param type
     * @return
     */
    List<Papers> getPapersByUserIdAndtypeFinish(@Param("userId") Integer userId, @Param("type") Integer type);

    /**
     * 根据用户id查询试卷分数
     * @param userId
     * @return
     */
    List<Papers> getPapersByUserId(Integer userId);

    /**
     * 根据专业id，科目id，查询类型查询试卷信息
     * @param classId
     * @param papersName
     * @param type
     * @return
     */
    List<Papers> getPapersByType(@Param("classId") Integer classId,@Param("papersName") String papersName,@Param("type") Integer type);
}
