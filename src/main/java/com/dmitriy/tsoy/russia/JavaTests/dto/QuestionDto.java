package com.dmitriy.tsoy.russia.JavaTests.dto;

import com.dmitriy.tsoy.russia.JavaTests.model.Answer;
import com.dmitriy.tsoy.russia.JavaTests.model.Question;

import java.util.List;
import java.util.Optional;

public class QuestionDto {

    private Optional<Question> question;
    private List<Answer> answers;

    public Optional<Question> getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = Optional.ofNullable(question);
    }

    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public QuestionDto(Optional<Question> question, List<Answer> answers) {
        this.question = question;
        this.answers = answers;
    }
}
