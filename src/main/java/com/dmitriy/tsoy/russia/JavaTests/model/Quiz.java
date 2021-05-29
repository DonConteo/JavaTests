package com.dmitriy.tsoy.russia.JavaTests.model;

import com.dmitriy.tsoy.russia.JavaTests.dto.QuestionDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;

public class Quiz {

    private String theme;
    private List<QuestionDto> list;
    @JsonProperty
    private boolean isPassed;

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public List<QuestionDto> getList() {
        return list;
    }
    public void setList(List<QuestionDto> list) {
        this.list = list;
    }

    public boolean isPassed() {
        return isPassed;
    }
    public void setPassed(boolean passed) {
        isPassed = passed;
    }

    public Quiz(String theme, List<QuestionDto> list, boolean isPassed) {
        this.theme = theme;
        this.list = list;
        this.isPassed = isPassed;
    }
}
