package com.yyhn.exam.entity;

/**
 * 就业训练每日一练实体类
 */
public class JobDayExercise {

    private int id;
    /**
     * 每日一练题目
     */
    private String title;
    /**
     * 答案
     */
    private String answer;
    /**
     * 评分标准
     */
    private String setStandard;
    /**
     * 提交的答案
     */
    private String submitAnswer;
    /**
     * 分数
     */
    private Integer score;
    /**
     * 备注信息
     */
    private String remark;
    /**
     * 所属专业
     */
    private Professional professional = new Professional();

    /**
     *所属科目
     */
    private Course course = new Course();

    private Integer professionalId;

    private Integer courseId;

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getSetStandard() {
        return setStandard;
    }

    public void setSetStandard(String setStandard) {
        this.setStandard = setStandard;
    }

    public String getSubmitAnswer() {
        return submitAnswer;
    }

    public void setSubmitAnswer(String submitAnswer) {
        this.submitAnswer = submitAnswer;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
