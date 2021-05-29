package com.dmitriy.tsoy.russia.JavaTests.dto;

import com.dmitriy.tsoy.russia.JavaTests.model.Answer;
import com.dmitriy.tsoy.russia.JavaTests.model.Question;

import java.util.List;

public class QuestionDto {

    private Question question;
    private List<Answer> answers;

    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public QuestionDto(Question question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }
}
