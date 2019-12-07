package com.example.demo.repository;

import com.example.demo.domain.Episode;
import com.example.demo.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialRepository  extends JpaRepository<Tutorial, Long> {
    Tutorial findById(long id);
    Tutorial findByCourseId(long id);
    List<Episode> findByMaterialId(long id);
    List<Tutorial> findAllByOrderByIdDesc();
}