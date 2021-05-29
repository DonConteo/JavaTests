package com.dmitriy.tsoy.russia.JavaTests.service;

import com.dmitriy.tsoy.russia.JavaTests.model.Answer;
import com.dmitriy.tsoy.russia.JavaTests.repository.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService {

    @Autowired
    AnswerRepository answerRepository;

    public List<Answer> getAnswersForQuestion(long id) {
        return answerRepository.getAnswersForQuestion(id);
    }

    public void saveAnswer(Answer answer) {
        answerRepository.save(answer);
    }

    public void deleteAnswersForQuestion(long id) {
        answerRepository.deleteAnswersForQuestion(id);
    }

    public void deleteAll() {
        answerRepository.deleteAll();
    }
}
