package com.example.demo.repository;

import com.example.demo.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EpisodeRepository  extends JpaRepository<Episode, Long> {
    List<Episode> findByMaterialId(long id);
}
