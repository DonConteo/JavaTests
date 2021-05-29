package com.dmitriy.tsoy.russia.JavaTests.service;

import com.dmitriy.tsoy.russia.JavaTests.dto.QuestionDto;
import com.dmitriy.tsoy.russia.JavaTests.model.Answer;
import com.dmitriy.tsoy.russia.JavaTests.model.Question;
import com.dmitriy.tsoy.russia.JavaTests.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    AnswerService answerService;

    public Question getQuestionById(long id) {
        return questionRepository.getById(id);
    }

    public List<QuestionDto> getAllQuestionDto() {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        List<Question> questions = questionRepository.findAll();
        for(Question q : questions) {
            List<Answer> answers = answerService.getAnswersForQuestion(q.getId());
            questionDtoList.add(new QuestionDto(q, answers));
        }
        return questionDtoList;
    }

    public QuestionDto getFullQuestion(long id) {
        Question question = questionRepository.getById(id);
        List<Answer> answers = answerService.getAnswersForQuestion(id);
        QuestionDto questionDto = new QuestionDto(question, answers);
        return questionDto;
    }

    public void saveQuestion(List<QuestionDto> questionDto) {
        for(QuestionDto qd : questionDto){
            Question question = new Question(qd.getQuestion().getTheme(),
                                                qd.getQuestion().getQuestionDescription(),
                                                qd.getQuestion().getCode());
            questionRepository.save(question);
            List<Answer> answers = qd.getAnswers();
            for(Answer a : answers) {
                a.setQuestion(questionRepository.getById(question.getId()));
                answerService.saveAnswer(a);
            }
        }
    }

    public void deleteQuestion(long id) {
        answerService.deleteAnswersForQuestion(id);
        questionRepository.deleteById(id);
    }

    public void deleteAllQuestions() {
        answerService.deleteAll();
        questionRepository.deleteAll();
    }

    public List<Question> getRandomQuestions(String theme) {
        List<Question> list = questionRepository.getRandomQuestions(theme);
        return list;
    }
}
