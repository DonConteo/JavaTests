package com.dmitriy.tsoy.russia.JavaTests.model;

import javax.persistence.*;

@Entity
@Table(name = "question")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String theme;
    @Column(columnDefinition = "text")
    private String questionDescription;
    @Column(columnDefinition = "text")
    private String code;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }
    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getQuestionDescription() {
        return questionDescription;
    }
    public void setQuestionDescription(String questionDescription) {
        this.questionDescription = questionDescription;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }

    public Question() {
    }

    public Question(String theme, String questionDescription, String code) {
        this.theme = theme;
        this.questionDescription = questionDescription;
        this.code = code;
    }
}
