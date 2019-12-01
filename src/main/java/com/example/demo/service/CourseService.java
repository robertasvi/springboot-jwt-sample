package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void delete(Course course) {
        courseRepository.delete(course);
    }

    public Course findById(long id) {
        return courseRepository.findById(id);
    };

    public List<Course> findAll() {
        return courseRepository.findAllByOrderByIdDesc();
    };
}
