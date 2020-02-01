package com.example.demo.service;

import com.example.demo.domain.Medical;
import com.example.demo.repository.MedicalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalService {

    @Autowired
    MedicalRepository medicalRepository;

    public Medical save(Medical med) {
        return medicalRepository.save(med);
    }

    public void delete(Medical med) {
        medicalRepository.delete(med);
    }

    public Medical findById(long id) {
        return medicalRepository.findById(id);
    };

    public List<Medical> findByUserId(long id) {
        return medicalRepository.findByUserId(id);
    };

    public List<Medical> findAll() {
        return medicalRepository.findAllByOrderByIdDesc();
    };

}
