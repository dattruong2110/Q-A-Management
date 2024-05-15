package com.codegym.finalexam.service.impl;

import com.codegym.finalexam.entity.Question;
import com.codegym.finalexam.repository.IQuestionRepository;
import com.codegym.finalexam.service.IQuestionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuestionService implements IQuestionService {
    private final IQuestionRepository questionRepository;

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Question findById(UUID id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void deleteById(UUID id) {
        questionRepository.deleteById(id);
    }

    @Override
    public void update(Question question) {
        questionRepository.save(question);
    }
}
