package com.yyhn.exam.vo;

import com.yyhn.exam.entity.TechnologyDayExercise;
import com.yyhn.exam.entity.TechnologyDayExerciseSubmit;

public class ErrorTechnologyDayExerciseSubmitVO extends TechnologyDayExerciseSubmit {
    private double exerciseCount;
    private double errorExerciseCount;
    private String exercisePercent;

    public double getExerciseCount() {
        return exerciseCount;
    }

    public void setExerciseCount(double exerciseCount) {
        this.exerciseCount = exerciseCount;
    }

    public double getErrorExerciseCount() {
        return errorExerciseCount;
    }

    public void setErrorExerciseCount(double errorExerciseCount) {
        this.errorExerciseCount = errorExerciseCount;
    }

    public String getExercisePercent() {
        return exercisePercent;
    }

    public void setExercisePercent(String exercisePercent) {
        this.exercisePercent = exercisePercent;
    }
}
