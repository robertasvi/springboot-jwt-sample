package com.example.demo.repository;

import com.example.demo.domain.Classroom;
import com.example.demo.domain.Enrolled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EnrolledRepository  extends JpaRepository<Enrolled, Long> {
    Enrolled findByClassroomId(long id);

    @Query(value = "SELECT COUNT(users_id) FROM enrolled_users eu WHERE eu.enrolled_id = :classroom_id", nativeQuery = true)
    long countEnrolledUsers(@Param("classroom_id") long id);
}
