package com.example.demo.repository;

import com.example.demo.domain.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuizRepository  extends JpaRepository<Quiz, Long> {
    Quiz findById(long id);
    Quiz findByCourseId(long id);
    List<Quiz> findByCourseIsNull();
    List<Quiz> findAllByOrderByIdDesc();

    @Query(value = "UPDATE quiz q SET q.rate = (q.rate + :rate) / 2 WHERE q.quiz_id = :quiz_id", nativeQuery = true)
    Quiz rate(@Param("quiz_id") long id, @Param("rate") Double rate);

    @Modifying
    @Query(value = "UPDATE quiz q SET q.course_id = :id WHERE q.id = :quiz_id", nativeQuery = true)
    void updateQuizCourse(@Param("id") long id, @Param("quiz_id") long quiz_id);

    @Modifying
    @Query(value = "UPDATE quiz q SET q.course_id = null WHERE q.course_id = :id", nativeQuery = true)
    void removeCourse(@Param("id") long id);
}