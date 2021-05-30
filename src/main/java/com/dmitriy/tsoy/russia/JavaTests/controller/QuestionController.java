package com.dmitriy.tsoy.russia.JavaTests.controller;

import com.dmitriy.tsoy.russia.JavaTests.dto.QuestionDto;
import com.dmitriy.tsoy.russia.JavaTests.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping()
    public String getAllQuestionsDto(Model model) {
        List<QuestionDto> list = questionService.getAllQuestionDto();
        model.addAttribute("list", list);
        return "question";
    }

    @PostMapping()
    public ResponseEntity<String> saveQuestion(@RequestBody List<QuestionDto> questionDto) {
        questionService.saveQuestion(questionDto);
        return new ResponseEntity<>("Тебе вопросов мало?", HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable(value="id") long id) {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>("Правильно, к черту этот вопрос!", HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteAllQuestions() {
        questionService.deleteAllQuestions();
        return new ResponseEntity<>("К черту все это!!!", HttpStatus.OK);
    }
}
