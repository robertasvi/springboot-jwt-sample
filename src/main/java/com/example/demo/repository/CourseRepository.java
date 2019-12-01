package com.example.demo.repository;

import com.example.demo.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository  extends JpaRepository<Course, Long> {
    Course findById(long id);
    List<Course> findAllByOrderByIdDesc();
}