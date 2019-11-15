package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository  extends JpaRepository<Material, Long> {}
