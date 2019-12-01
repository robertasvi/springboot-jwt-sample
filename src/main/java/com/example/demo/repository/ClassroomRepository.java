package com.example.demo.repository;

import com.example.demo.domain.Classroom;
import com.example.demo.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassroomRepository  extends JpaRepository<Classroom, Long> {
    Classroom findById(long id);
    List<Classroom> findAllByOrderByIdDesc();
}