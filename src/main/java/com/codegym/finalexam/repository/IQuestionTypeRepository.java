package com.codegym.finalexam.repository;

import com.codegym.finalexam.entity.QuestionType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IQuestionTypeRepository extends JpaRepository<QuestionType, UUID> {
}
