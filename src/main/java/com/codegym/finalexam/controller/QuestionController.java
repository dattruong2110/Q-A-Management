package com.codegym.finalexam.controller;

import com.codegym.finalexam.entity.Question;
import com.codegym.finalexam.service.IQuestionService;
import com.codegym.finalexam.service.IQuestionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.UUID;

@Controller
@RequestMapping("/questions")
@AllArgsConstructor
public class QuestionController {
    private final IQuestionService questionService;
    private final IQuestionTypeService questionTypeService;

    @GetMapping
    public ModelAndView showQuestion() {
        ModelAndView modelAndView = new ModelAndView("Question/ListQuestion");
        modelAndView.addObject("questions", questionService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("Question/CreateQuestion");
        modelAndView.addObject("question", new Question());
        modelAndView.addObject("question_types", questionTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public String createBook(Question question) {
        questionService.save(question);
        return "redirect:/questions";
    }

    @GetMapping("/{id}")
    public ModelAndView showQuestion(@PathVariable UUID id) {
        ModelAndView modelAndView = new ModelAndView("Question/InfoQuestion");
        modelAndView.addObject("questions", questionService.findById(id));
        modelAndView.addObject("question_types", questionTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/update/{id}")
    public ModelAndView showUpdateForm(@PathVariable UUID id) {
        ModelAndView modelAndView = new ModelAndView("Question/UpdateQuestion");
        modelAndView.addObject("question", questionService.findById(id));
        modelAndView.addObject("question_types", questionTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/update/{id}")
    public String update(Question question) {
        questionService.update(question);
        return "redirect:/questions";
    }

    @GetMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable UUID id) {
        questionService.deleteById(id);
        return "redirect:/questions";
    }
}
