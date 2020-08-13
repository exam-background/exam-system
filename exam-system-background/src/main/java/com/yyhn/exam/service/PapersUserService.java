package com.yyhn.exam.service;

import com.yyhn.exam.entity.PapersCourse;
import com.yyhn.exam.entity.PapersUser;

import java.util.List;

public interface PapersUserService {
    /**
     * 根据试卷id删除考试用户
     * @param id
     * @return
     */
    public void deletePapersUser(Integer id) throws RuntimeException;

    /**
     * 添加考试用户
     * @param papersUser
     * @return
     */
    public void insertPapersUser(PapersUser papersUser) throws RuntimeException;

    /**
     * 根据试卷id查询学生
     * @param id
     * @return
     */
    public List<PapersUser> getPapersUserByPapersId(Integer id);
}
