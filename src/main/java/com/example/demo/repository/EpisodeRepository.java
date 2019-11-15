package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository  extends JpaRepository<Episode, Long> {}
