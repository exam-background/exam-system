package com.yyhn.exam.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yyhn.exam.entity.JobDayExerciseSubmit;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobDayExerciseSubmitMapper extends BaseMapper<JobDayExerciseSubmit> {
    /**
     * 根据学生id查询做过的就业每日一练
     * @param id
     * @return
     */
    List<JobDayExerciseSubmit> getJobDayExerciseSubmitByUserId(Integer id);

    /**
     * 根据用户id查询就业训练错题
     * @param userid
     * @return
     */
    List<JobDayExerciseSubmit> getJobDayExerciseSubmitByRight(Integer userid);
}
