package com.codegym.finalexam.service;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CRUDService<T> {
    List<T> findAll();
    T findById(UUID id);
    void save(T t);
    void deleteById(UUID id);
    void update(T t);
}
