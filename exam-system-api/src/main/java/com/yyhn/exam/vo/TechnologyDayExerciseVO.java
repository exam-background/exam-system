package com.yyhn.exam.vo;

import lombok.Data;

import java.util.List;

@Data
public class TechnologyDayExerciseVO {
    private  String title;
    private String standardAnswer;
    private String submitAnswer;
    private int types;
    private String items;
    private String date;
    private String [] xuan;
}
