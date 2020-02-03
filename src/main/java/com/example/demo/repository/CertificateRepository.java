package com.example.demo.repository;

import com.example.demo.domain.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CertificateRepository  extends JpaRepository<Certificate, Long> {
    Certificate findById(long id);
    List<Certificate> findByUserIdOrderByIdDesc(long id);
    List<Certificate> findAllByOrderByIdDesc();

}