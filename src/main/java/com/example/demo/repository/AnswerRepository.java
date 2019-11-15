package com.example.demo.repository;

import com.example.demo.domain.Answer;
import com.example.demo.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository  extends JpaRepository<Answer, Long> {}