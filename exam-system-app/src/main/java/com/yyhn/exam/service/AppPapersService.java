package com.yyhn.exam.service;

import com.yyhn.exam.entity.Papers;

import java.util.List;

public interface AppPapersService {
    /**
     * 根据用户id和试卷类型查询待考试卷
     * @param userId
     * @param type
     * @return
     */
    List<Papers> getPapersByUserIdAndtype(Integer userId, Integer type);

    /**
     * 根据用户id和试卷类型查询已考试卷
     * @param userId
     * @param type
     * @return
     */
    List<Papers> getPapersByUserIdAndtypeFinish(Integer userId, Integer type);

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
