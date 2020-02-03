package com.example.demo.service;

import com.example.demo.domain.Tutorial;
import com.example.demo.domain.Visa;
import com.example.demo.dto.Rate;
import com.example.demo.repository.TutorialRepository;
import com.example.demo.repository.VisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisaService {

    @Autowired
    VisaRepository visaRepository;

    public Visa save(Visa visa) {
        return visaRepository.save(visa);
    }

    public void delete(Visa visa) {
        visaRepository.delete(visa);
    }

    public Visa findById(long id) {
        return visaRepository.findById(id);
    };

    public List<Visa> findByUserId(long id) {
        return visaRepository.findByUserIdOrderByIdDesc(id);
    };

    public List<Visa> findAll() {
        return visaRepository.findAllByOrderByIdDesc();
    };

}
