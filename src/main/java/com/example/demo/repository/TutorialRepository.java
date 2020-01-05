package com.example.demo.repository;

import com.example.demo.domain.Quiz;
import com.example.demo.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TutorialRepository  extends JpaRepository<Tutorial, Long> {
    Tutorial findById(long id);
    Tutorial findByCourseId(long id);
    List<Tutorial> findByCourseIsNull();
    List<Tutorial> findAllByOrderByIdDesc();

    @Query(value = "UPDATE tutorial t SET t.rate = t.rate + :rate WHERE t.tutorial_id = :tutorial_id", nativeQuery = true)
    Tutorial rate(@Param("tutorial_id") long id, @Param("rate") Double rate);

    @Modifying
    @Query(value = "UPDATE tutorial t SET t.course_id = :id WHERE t.id = :tutorial_id", nativeQuery = true)
    void updateTutorialCourse(@Param("id") long id, @Param("tutorial_id") long tutorial_id);

    @Modifying
    @Query(value = "UPDATE tutorial t SET t.course_id = null WHERE t.course_id = :id", nativeQuery = true)
    void removeCourse(@Param("id") long id);
}