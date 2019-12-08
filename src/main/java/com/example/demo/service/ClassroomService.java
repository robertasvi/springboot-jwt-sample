package com.example.demo.service;

import com.example.demo.domain.Classroom;
import com.example.demo.domain.Enrolled;
import com.example.demo.dto.Rate;
import com.example.demo.repository.ClassroomRepository;
import com.example.demo.repository.EnrolledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    EnrolledRepository enrolledRepository;

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void delete(Classroom classroom) {
        classroomRepository.delete(classroom);
    }

    public Classroom findById(long id) {
        return classroomRepository.findById(id);
    };

    public Enrolled findByClassroomId(long id) {
        return enrolledRepository.findByClassroomId(id);
    };

    public long countEnrolledUsers(long id) {
        return enrolledRepository.countEnrolledUsers(id);
    };

    public List<Classroom> findAll() {
        return classroomRepository.findAllByOrderByIdDesc();
    };

    public Classroom rate(Rate rate) {
        return classroomRepository.rate(rate.getSourceId(), rate.getValue());
    }
}
