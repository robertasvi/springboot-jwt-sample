package com.example.demo.repository;

import com.example.demo.domain.Assignment;
import com.example.demo.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AssignmentRepository  extends JpaRepository<Assignment, Long> {}