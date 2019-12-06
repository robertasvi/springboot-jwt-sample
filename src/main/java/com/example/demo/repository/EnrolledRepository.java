package com.example.demo.repository;

import com.example.demo.domain.Enrolled;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrolledRepository  extends JpaRepository<Enrolled, Long> {
    Enrolled findByClassroomId(long id);
}
