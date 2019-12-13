package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @CachePut(value = "course", key = "#course.id")
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @CacheEvict(value = "course", key = "#course.id")
    public void delete(Course course) {
        courseRepository.delete(course);
    }

    @Cacheable(value = "classrooms", key = "#id")
    public Course findById(long id) {
        return courseRepository.findById(id);
    };

    public List<Course> findAll() {
        return courseRepository.findAllByOrderByIdDesc();
    };
}
