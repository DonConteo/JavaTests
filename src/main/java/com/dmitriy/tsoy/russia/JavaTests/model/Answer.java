package com.dmitriy.tsoy.russia.JavaTests.model;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String answer;
    private boolean isCorrect;
    private String answerDescription;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "question_id")
    private Question question;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public String getAnswerDescription() {
        return answerDescription;
    }
    public void setAnswerDescription(String answerDescription) {
        this.answerDescription = answerDescription;
    }

    public Question getQuestion() {
        return question;
    }
    public void setQuestion(Question question) {
        this.question = question;
    }

    public Answer() {
    }

    public Answer(String answer, boolean isCorrect, String answerDescription, Question question) {
        this.answer = answer;
        this.isCorrect = isCorrect;
        this.answerDescription = answerDescription;
        this.question = question;
    }
}
