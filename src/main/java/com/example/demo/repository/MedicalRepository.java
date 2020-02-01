package com.example.demo.repository;

import com.example.demo.domain.Medical;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicalRepository  extends JpaRepository<Medical, Long> {
    Medical findById(long id);
    List<Medical> findByUserId(long id);
    List<Medical> findAllByOrderByIdDesc();

}