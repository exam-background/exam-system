package com.yyhn.exam.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@TableName("exam_papers")
public class Papers implements Serializable {
    /**
     * id，主键
     */
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 试卷名称
     */
    private String name;
    /**
     * 就业训练还是技术考核。0：就业训练，1：技术考核
     */
    private Integer type;
    /**
     * 题目数量
     */
    private Integer sum;
    /**
     * 出题人
     */
    private String papersName;
    /**
     * 试卷生成时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date buildPapersDate = new Date();
    /**
     * 考试开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date papersStartDate;
    /**
     * 考试结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date papersOverDate;
    /**
     * 是否发布
     */
    private Integer ispublish;
    /**
     * 查询时根据科目id查询
     */
    @TableField(exist = false)
    private Integer course_id;
    /**
     * 查询时根据专业id查询
     */
    @TableField(exist = false)
    private Integer professionalId;

    /**
     * 冗余字段，试卷的所有科目名称
     */
    @TableField(exist = false)
    private String course="";
    /**
     * 冗余字段，试卷的考核类型。是就业训练还是技术考核
     */
    @TableField(exist = false)
    private String typeString = "就业训练";
    /**
     * 冗余字段，试卷题目的科目id
     */
    @TableField(exist = false)
    private String[] courseId;
    /**
     * 冗余字段，参加该试卷考试的用户id
     */
    @TableField(exist = false)
    private String[] userId;
    /**
     * 冗余字段，是否发布
     */
    @TableField(exist = false)
    private String ispublishString = "未发布";

    /**
     * 试卷所属科目
     */
    @TableField(exist = false)
    private List<Course> courseList = new ArrayList<Course>();
    /**
     * 试卷对应专业
     */
    @TableField(exist = false)
    private Professional professional = new Professional();
    /**
     * 试卷对应考试用户
     */
    @TableField(exist = false)
    private List<SysUser> sysUserList = new ArrayList<SysUser>();
    /**
     * 试卷对应考试题目
     */
    @TableField(exist = false)
    private List<PapersTitle> papersTitleList = new ArrayList<PapersTitle>();
    /**
     * 试卷对应科目关系表
     */
    @TableField(exist = false)
    private List<PapersCourse> papersCourseList = new ArrayList<PapersCourse>();
    /**
     * 该试卷考试学生
     */
    @TableField(exist = false)
    private List<Student> studentList = new ArrayList<Student>();
    /**
     * 试卷考试作答
     */
    @TableField(exist = false)
    private List<PapersUserResult> papersUserResultList = new ArrayList<PapersUserResult>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getPapersName() {
        return papersName;
    }

    public void setPapersName(String papersName) {
        this.papersName = papersName;
    }

    public Date getBuildPapersDate() {
        return buildPapersDate;
    }

    public void setBuildPapersDate(Date buildPapersDate) {
        this.buildPapersDate = buildPapersDate;
    }

    public Date getPapersStartDate() {


        return papersStartDate;
    }

    public void setPapersStartDate(Date papersStartDate) {
        this.papersStartDate = papersStartDate;
    }

    public Date getPapersOverDate() {
        return papersOverDate;
    }

    public void setPapersOverDate(Date papersOverDate) {
        this.papersOverDate = papersOverDate;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public List<SysUser> getSysUserList() {
        return sysUserList;
    }

    public void setSysUserList(List<SysUser> sysUserList) {
        this.sysUserList = sysUserList;
    }

    public List<PapersTitle> getPapersTitleList() {
        return papersTitleList;
    }

    public void setPapersTitleList(List<PapersTitle> papersTitleList) {
        this.papersTitleList = papersTitleList;
    }

    public Professional getProfessional() {
        return professional;
    }

    public void setProfessional(Professional professional) {
        this.professional = professional;
    }

    public Integer getProfessionalId() {
        return professionalId;
    }

    public void setProfessionalId(Integer professionalId) {
        this.professionalId = professionalId;
    }

    public String getTypeString() {
        return typeString;
    }

    public void setTypeString(String typeString) {
        this.typeString = typeString;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public List<PapersCourse> getPapersCourseList() {
        return papersCourseList;
    }

    public void setPapersCourseList(List<PapersCourse> papersCourseList) {
        this.papersCourseList = papersCourseList;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public String[] getCourseId() {
        return courseId;
    }

    public void setCourseId(String[] courseId) {
        this.courseId = courseId;
    }

    public String[] getUserId() {
        return userId;
    }

    public void setUserId(String[] userId) {
        this.userId = userId;
    }

    public Integer getIspublish() {
        return ispublish;
    }

    public String getIspublishString() {
        return ispublishString;
    }

    public void setIspublishString(String ispublishString) {
        this.ispublishString = ispublishString;
    }

    public void setIspublish(Integer ispublish) {
        this.ispublish = ispublish;
    }

    public List<PapersUserResult> getPapersUserResultList() {
        return papersUserResultList;
    }

    public void setPapersUserResultList(List<PapersUserResult> papersUserResultList) {
        this.papersUserResultList = papersUserResultList;
    }

    public Papers(Integer id, String name, Integer type, Integer sum, String papersName, Date buildPapersDate, Date papersStartDate, Date papersOverDate, Integer ispublish, Integer course_id, Integer professionalId, String course, String typeString, String[] courseId, String[] userId, String ispublishString, List<Course> courseList, Professional professional, List<SysUser> sysUserList, List<PapersTitle> papersTitleList, List<PapersCourse> papersCourseList, List<Student> studentList, List<PapersUserResult> papersUserResultList) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.sum = sum;
        this.papersName = papersName;
        this.buildPapersDate = buildPapersDate;
        this.papersStartDate = papersStartDate;
        this.papersOverDate = papersOverDate;
        this.ispublish = ispublish;
        this.course_id = course_id;
        this.professionalId = professionalId;
        this.course = course;
        this.typeString = typeString;
        this.courseId = courseId;
        this.userId = userId;
        this.ispublishString = ispublishString;
        this.courseList = courseList;
        this.professional = professional;
        this.sysUserList = sysUserList;
        this.papersTitleList = papersTitleList;
        this.papersCourseList = papersCourseList;
        this.studentList = studentList;
        this.papersUserResultList = papersUserResultList;
    }

    public Papers() {
    }

    @Override
    public String toString() {
        return "Papers{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", sum=" + sum +
                ", papersName='" + papersName + '\'' +
                ", buildPapersDate=" + buildPapersDate +
                ", papersStartDate=" + papersStartDate +
                ", papersOverDate=" + papersOverDate +
                ", ispublish=" + ispublish +
                ", course_id=" + course_id +
                ", professionalId=" + professionalId +
                ", course='" + course + '\'' +
                ", typeString='" + typeString + '\'' +
                ", courseId=" + Arrays.toString(courseId) +
                ", userId=" + Arrays.toString(userId) +
                ", ispublishString='" + ispublishString + '\'' +
                ", courseList=" + courseList +
                ", professional=" + professional +
                ", sysUserList=" + sysUserList +
                ", papersTitleList=" + papersTitleList +
                ", papersCourseList=" + papersCourseList +
                ", studentList=" + studentList +
                ", papersUserResultList=" + papersUserResultList +
                '}';
    }
}
