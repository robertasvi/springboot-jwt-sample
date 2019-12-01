package com.example.demo.service;

import com.example.demo.domain.Classroom;
import com.example.demo.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public void delete(Classroom classroom) {
        classroomRepository.delete(classroom);
    }

    public Classroom findById(long id) {
        return classroomRepository.findById(id);
    };

    public List<Classroom> findAll() {
        return classroomRepository.findAllByOrderByIdDesc();
    };
}
