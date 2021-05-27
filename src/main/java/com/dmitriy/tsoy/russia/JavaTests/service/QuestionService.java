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

    public Optional<Question> getQuestionById(long id) {
        return questionRepository.findById(id);
    }

    public List<QuestionDto> getAllQuestionDto() {
        List<QuestionDto> questionDtoList = new ArrayList<>();
        List<Question> questions = questionRepository.findAll();
        for(Question q : questions) {
            List<Answer> answers = answerService.getAnswersForQuestion(q.getId());
            questionDtoList.add(new QuestionDto(Optional.of(q), answers));
        }
        return questionDtoList;
    }

    public QuestionDto getFullQuestion(long id) {
        Optional<Question> question = questionRepository.findById(id);
        List<Answer> answers = answerService.getAnswersForQuestion(id);
        QuestionDto questionDto = new QuestionDto(question, answers);
        return questionDto;
    }

    public void saveQuestion(QuestionDto questionDto) {
        Question question = new Question(questionDto.getQuestion().get().getTheme(),
                                            questionDto.getQuestion().get().getQuestionDescription(),
                                            questionDto.getQuestion().get().getCode());
        questionRepository.save(question);
        List<Answer> answers = questionDto.getAnswers();
        for(Answer a : answers) {
            a.setQuestion(questionRepository.getById(question.getId()));
            answerService.saveAnswer(a);
        }
    }

    public void deleteQuestion(long id) {
        answerService.deleteAnswersForQuestion(id);
        questionRepository.deleteById(id);
    }
}
