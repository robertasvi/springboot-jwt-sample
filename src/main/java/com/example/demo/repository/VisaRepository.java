package com.example.demo.repository;

import com.example.demo.domain.Visa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VisaRepository  extends JpaRepository<Visa, Long> {
    Visa findById(long id);
    List<Visa> findByUserId(long id);
    List<Visa> findAllByOrderByIdDesc();

}