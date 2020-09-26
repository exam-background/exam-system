package com.yyhn.exam.entity;

import lombok.Data;

@Data
public class Teacher implements java.io.Serializable {
    private static final long serialVersionUID = -5179465430732187462L;
    /**
     * ID
     */
    private Integer id;
    /**
     * 老师名称
     */
        private String teacherName;
    /**
     * 老师描述
     */
    private String teacherDesc;

    /**
     * 老师所属职位professional_name
     */
    private String teacherPosition;
    /**
     * 老师所属专业
     */

    private String professionalName;
    private Professional professional = new Professional();

    private String loginName;

    private String loginPassword;

    private String email;
}
