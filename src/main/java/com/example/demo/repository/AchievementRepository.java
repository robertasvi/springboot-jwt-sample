package com.example.demo.repository;

import com.example.demo.domain.Achievement;
import com.example.demo.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AchievementRepository  extends JpaRepository<Achievement, Long> {}
