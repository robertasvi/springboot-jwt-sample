package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.CustomGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomGroupRepository  extends JpaRepository<CustomGroup, Long> {}
