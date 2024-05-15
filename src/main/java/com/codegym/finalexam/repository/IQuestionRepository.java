package com.codegym.finalexam.repository;

import com.codegym.finalexam.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IQuestionRepository extends JpaRepository<Question, UUID> {
}
