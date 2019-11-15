package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository  extends JpaRepository<Quiz, Long> {}