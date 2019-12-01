package com.example.demo.service;

import com.example.demo.domain.Tutorial;
import com.example.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {

    @Autowired
    TutorialRepository tutorialRepository;

    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public void delete(Tutorial tutorial) {
        tutorialRepository.delete(tutorial);
    }

    public Tutorial findById(long id) {
        return tutorialRepository.findById(id);
    };

    public List<Tutorial> findAll() {
        return tutorialRepository.findAllByOrderByIdDesc();
    };
}
