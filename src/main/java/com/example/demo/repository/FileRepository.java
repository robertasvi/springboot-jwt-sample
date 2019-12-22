package com.example.demo.repository;

import com.example.demo.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    File findById(long id);

    @Query(value = "SELECT f.id, f.name, f.directory, f.created, f.type, f.size FROM file f " +
            "JOIN tutorial_materials tm ON tm.materials_id = f.id " +
            "WHERE tm.tutorial_id = :tutorial_id ", nativeQuery = true)
    List<File> findByTutorialId(@Param("tutorial_id") long id);
}

