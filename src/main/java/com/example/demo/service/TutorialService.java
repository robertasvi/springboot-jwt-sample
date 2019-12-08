package com.example.demo.service;

import com.example.demo.domain.Episode;
import com.example.demo.domain.Tutorial;
import com.example.demo.dto.Rate;
import com.example.demo.repository.EpisodeRepository;
import com.example.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TutorialService {

    @Autowired
    TutorialRepository tutorialRepository;

    @Autowired
    EpisodeRepository episodeRepository;

    public Tutorial save(Tutorial tutorial) {
        return tutorialRepository.save(tutorial);
    }

    public void delete(Tutorial tutorial) {
        tutorialRepository.delete(tutorial);
    }

    public Tutorial findById(long id) {
        return tutorialRepository.findById(id);
    };

    public Tutorial findByCourseId(long id) {
        return tutorialRepository.findByCourseId(id);
    };

    public List<Episode> findByMaterialId(long id) { return episodeRepository.findByMaterialId(id); }

    public List<Tutorial> findAll() {
        return tutorialRepository.findAllByOrderByIdDesc();
    };

    public Tutorial rate(Rate rate) {
        return tutorialRepository.rate(rate.getSourceId(), rate.getValue());
    }
}
