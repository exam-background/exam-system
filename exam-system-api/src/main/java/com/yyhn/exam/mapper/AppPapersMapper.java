package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.Papers;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppPapersMapper extends BaseMapper<Papers> {
    /**
     * 根据用户id和试卷类型查询待考试卷
     * @param userId
     * @param type
     * @return
     */
    List<Papers> getPapersByUserIdAndtype(@Param("userId") Integer userId,@Param("type") Integer type);

    /**
     * 根据用户id和试卷类型查询已考试卷
     * @param userId
     * @param type
     * @return
     */
    List<Papers> getPapersByUserIdAndtypeFinish(@Param("userId") Integer userId,@Param("type") Integer type);

    /**
     * 根据试卷id查询试卷
     * @param id
     * @return
     */
    Papers getPapersById(Integer id);

    /**
     * 根据试卷id查询试卷和作答信息
     * @param id
     * @return
     */
    Papers getPapersByIdStudent(Integer id);
}
