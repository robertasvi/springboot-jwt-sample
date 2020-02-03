package com.example.demo.service;

import com.example.demo.domain.Absence;
import com.example.demo.domain.Certificate;
import com.example.demo.repository.AbsenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AbsenceService {

    @Autowired
    AbsenceRepository absenceRepository;

    public void approve(long id) {
        absenceRepository.approve(id);
    }

    public Absence save(Absence absence) {
        return absenceRepository.save(absence);
    }

    public void delete(Absence absence) {
        absenceRepository.delete(absence);
    }

    public Absence findById(long id) {
        return absenceRepository.findById(id);
    };

    public List<Absence> findByUserId(long id) {
        return absenceRepository.findByUserIdAndApprovedFalseOrderByIdDesc(id);
    };

    public List<Absence> findAll() {
        return absenceRepository.findAllByOrderByIdDesc();
    };

}
