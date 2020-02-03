package com.example.demo.service;

import com.example.demo.domain.Certificate;
import com.example.demo.domain.Tutorial;
import com.example.demo.domain.Visa;
import com.example.demo.dto.Rate;
import com.example.demo.repository.CertificateRepository;
import com.example.demo.repository.TutorialRepository;
import com.example.demo.repository.VisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateService {

    @Autowired
    CertificateRepository certificateRepository;

    public Certificate save(Certificate cert) {
        return certificateRepository.save(cert);
    }

    public void delete(Certificate cert) {
        certificateRepository.delete(cert);
    }

    public Certificate findById(long id) {
        return certificateRepository.findById(id);
    };

    public List<Certificate> findByUserId(long id) {
        return certificateRepository.findByUserIdOrderByIdDesc(id);
    };

    public List<Certificate> findAll() {
        return certificateRepository.findAllByOrderByIdDesc();
    };

}
