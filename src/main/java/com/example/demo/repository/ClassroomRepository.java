package com.example.demo.repository;

import com.example.demo.domain.Classroom;
import com.example.demo.domain.Country;
import com.example.demo.domain.Enrolled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface ClassroomRepository  extends JpaRepository<Classroom, Long> {
    Classroom findById(long id);
    List<Classroom> findAllByOrderByIdDesc();

    @Query(value = "UPDATE classroom c SET c.rate = (c.rate + :rate) / 2 WHERE c.classroom_id = :classroom_id", nativeQuery = true)
    Classroom rate(@Param("classroom_id") long id, @Param("rate") Double rate);

    @Query(value = "SELECT c.id, c.name, c.description, c.course_id, c.rate, c.score, c.created FROM enrolled e " +
            "JOIN enrolled_users eu ON e.id = eu.enrolled_id " +
            "JOIN classroom c ON c.id =  e.classroom_id " +
            "WHERE eu.users_id = :user_id ", nativeQuery = true)
    List<Classroom> findByUserId(@Param("user_id") long id);
}

