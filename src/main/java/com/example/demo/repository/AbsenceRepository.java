package com.example.demo.repository;

import com.example.demo.domain.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AbsenceRepository  extends JpaRepository<Absence, Long> {
    Absence findById(long id);
    List<Absence> findByUserIdAndApprovedFalseOrderByIdDesc(long id);
    List<Absence> findAllByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query(value = "UPDATE absence a SET approved = 1 WHERE a.id = :id", nativeQuery = true)
    void approve(@Param("id") long id);
}