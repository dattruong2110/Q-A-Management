package com.codegym.finalexam.controller;

import com.codegym.finalexam.entity.Question;
import com.codegym.finalexam.entity.QuestionType;
import com.codegym.finalexam.service.IQuestionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/question-types")
@AllArgsConstructor
public class QuestionTypeController {
    private final IQuestionTypeService questionTypeService;

    @GetMapping
    public ModelAndView showQuestionType() {
        ModelAndView modelAndView = new ModelAndView("QuestionType/ListQuestionType");
        modelAndView.addObject("question_types", questionTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("QuestionType/CreateQuestionType");
        modelAndView.addObject("question_type", new QuestionType());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createBook(QuestionType questionType) {
        questionTypeService.save(questionType);
        return "redirect:/question-types";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable UUID id) {
        questionTypeService.deleteById(id);
        return "redirect:/question-types";
    }
}
