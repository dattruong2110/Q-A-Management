package com.codegym.finalexam.service.impl;

import com.codegym.finalexam.entity.QuestionType;
import com.codegym.finalexam.repository.IQuestionTypeRepository;
import com.codegym.finalexam.service.IQuestionTypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class QuestionTypeService implements IQuestionTypeService {
    private final IQuestionTypeRepository questionTypeRepository;
    @Override
    public List<QuestionType> findAll() {
        return questionTypeRepository.findAll();
    }

    @Override
    public QuestionType findById(UUID id) {
        return null;
    }

    @Override
    public void save(QuestionType questionType) {
        questionTypeRepository.save(questionType);
    }

    @Override
    public void deleteById(UUID id) {
        questionTypeRepository.deleteById(id);
    }

    @Override
    public void update(QuestionType questionType) {

    }
}
