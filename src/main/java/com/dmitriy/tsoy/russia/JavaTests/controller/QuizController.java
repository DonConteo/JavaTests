package com.dmitriy.tsoy.russia.JavaTests.controller;

import com.dmitriy.tsoy.russia.JavaTests.model.Quiz;
import com.dmitriy.tsoy.russia.JavaTests.service.QuizService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @GetMapping()
    public String getQuiz(@RequestParam String theme, Model model) throws JsonProcessingException {
        Quiz quiz = quizService.getQuiz(theme);
        model.addAttribute("quiz", quiz);
        return "quiz";
    }
}
