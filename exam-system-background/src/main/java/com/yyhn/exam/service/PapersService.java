package com.yyhn.exam.service;

import com.yyhn.exam.entity.Papers;

import java.util.List;

public interface PapersService {
    /**
     * 条件查询试卷
     * @param papers
     * @return
     */
    public List<Papers> getPapersAll(Papers papers);

    /**
     * 根据id删除试卷
     * @param id
     * @return
     */
    public void deletePapers(Integer id) throws RuntimeException;

    /**
     * 添加试卷
     * @param papers
     * @return
     */
    public void insertPapers(Papers papers) throws RuntimeException;

    /**
     * 发布试卷
     * @param id
     * @return
     */
    public int publishPapers(Integer id);

    /**
     * 条件查询已发布试卷
     * @param papers
     * @return
     */
    List<Papers> getPapersAllPublish(Papers papers);

    /**
     * 添加试卷和对应的表数据
     * @param papers
     */
    public void insertPapersAll(Papers papers) throws Exception;

    /**
     * 删除书卷和对应的表数据
     * @param integerList
     * @throws RuntimeException
     */
    public void deletePapersAll(List<Integer> integerList) throws RuntimeException;

    /**
     * 修改试卷基础信息
     * @param papers
     */
    public int updatePapers(Papers papers);

    /**
     * 根据用户id和试卷类型查询已考试卷
     * @param userId
     * @param type
     * @return
     */
    List<Papers> getPapersByUserIdAndtypeFinish(Integer userId, Integer type);

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
    List<Papers> getPapersByType(Integer classId, String papersName, Integer type);
}
