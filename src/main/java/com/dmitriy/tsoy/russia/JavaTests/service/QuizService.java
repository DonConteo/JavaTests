package com.dmitriy.tsoy.russia.JavaTests.service;

import com.dmitriy.tsoy.russia.JavaTests.dto.QuestionDto;
import com.dmitriy.tsoy.russia.JavaTests.model.Answer;
import com.dmitriy.tsoy.russia.JavaTests.model.Question;
import com.dmitriy.tsoy.russia.JavaTests.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class QuizService {

    @Autowired
    AnswerService answerService;
    @Autowired
    QuestionService questionService;

    public Quiz getQuiz(String theme) {
        List<QuestionDto> questionDtoList = new LinkedList<>();
        List<Question> questionList = questionService.getRandomQuestions(theme);
        for(Question q : questionList) {
            List<Answer> answerList = answerService.getAnswersForQuestion(q.getId());
            QuestionDto questionDto = new QuestionDto(q, answerList);
            questionDtoList.add(questionDto);
        }
        Quiz quiz = new Quiz(theme, questionDtoList, false);
        return quiz;
    }
}
