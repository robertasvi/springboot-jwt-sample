package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository  extends JpaRepository<Type, Long> {}