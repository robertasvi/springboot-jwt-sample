package com.example.demo.repository;

import com.example.demo.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository  extends JpaRepository<Quiz, Long> {
    Quiz findById(long id);
    List<Quiz> findAllByOrderByIdDesc();
}