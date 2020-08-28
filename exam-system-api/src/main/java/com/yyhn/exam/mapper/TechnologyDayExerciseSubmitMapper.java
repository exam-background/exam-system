package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;
import com.yyhn.exam.vo.ErrorTechnologyDayExerciseSubmitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TechnologyDayExerciseSubmitMapper extends BaseMapper<TechnologyDayExerciseSubmit> {
    /**
     * 根据学生id查询技术训练每日一练
     * @param id
     * @return
     */
    List<TechnologyDayExerciseSubmit> getTechnologyDayExerciseSubmitByUserId(Integer id);

    /**
     * 根据学生id查询错误的技术训练每日一练
     * @param userid
     * @return
     */
    List<TechnologyDayExerciseSubmit> getTechnologyDayExerciseSubmitByRight(Integer userid);
}
