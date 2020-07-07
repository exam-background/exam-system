package com.yyhn.exam.entity;

/**
 * 就业示范学习
 */
public class JobExampleStudy {

    private int id;

    /**
     * 题目题干
     */
    private String title;

    /**
     * 答案
     */
    private String answer;

    /**
     * 音频转换后的文字信息
     */
    private String viedoConvertContent;

    /**
     * 示范音频存储地址
     */
    private String viedoUrl;

    /**
     * 分数
     */
    private int score;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 专业
     */
    private Professional professional = new Professional();

    /**
     * 科目
     */
    private Course course = new Course();

    public String toString(){
        return "{ id :"+id+" \t title :"+title+" \t  answer:"+answer+" \t "+viedoConvertContent+" \t  viedoUrl: "+viedoUrl+" \t score : "+score+"\t remark :"+remark+" \t professional :"+professional+"\t course:"+course+"}";
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

    public String getViedoConvertContent() {
        return viedoConvertContent;
    }

    public void setViedoConvertContent(String viedoConvertContent) {
        this.viedoConvertContent = viedoConvertContent;
    }

    public String getViedoUrl() {
        return viedoUrl;
    }

    public void setViedoUrl(String viedoUrl) {
        this.viedoUrl = viedoUrl;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
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
