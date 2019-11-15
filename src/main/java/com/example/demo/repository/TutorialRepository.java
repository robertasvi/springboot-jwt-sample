package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TutorialRepository  extends JpaRepository<Tutorial, Long> {}