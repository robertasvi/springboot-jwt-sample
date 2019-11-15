package com.example.demo.repository;

import com.example.demo.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository  extends JpaRepository<Company, Long> {

    Optional<Company> findByName(String name);

    Company findById(long id);
}
