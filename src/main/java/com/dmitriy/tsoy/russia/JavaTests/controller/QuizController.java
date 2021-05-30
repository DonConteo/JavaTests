package com.dmitriy.tsoy.russia.JavaTests.controller;

import com.dmitriy.tsoy.russia.JavaTests.model.Quiz;
import com.dmitriy.tsoy.russia.JavaTests.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping("{theme}")
    public ResponseEntity<Quiz> getQuiz(@PathVariable(value = "theme") String theme) {
        Quiz quiz = quizService.getQuiz(theme);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/quiz/{theme}");
        return new ResponseEntity<>(quiz, headers, HttpStatus.OK);
    }
}
