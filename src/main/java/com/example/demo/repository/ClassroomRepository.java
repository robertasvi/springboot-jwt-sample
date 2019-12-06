package com.example.demo.repository;

import com.example.demo.domain.Classroom;
import com.example.demo.domain.Country;
import com.example.demo.domain.Enrolled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface ClassroomRepository  extends JpaRepository<Classroom, Long> {
    Classroom findById(long id);
    List<Classroom> findAllByOrderByIdDesc();
}

