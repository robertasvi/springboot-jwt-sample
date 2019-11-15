package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository  extends JpaRepository<Level, Long> {}
