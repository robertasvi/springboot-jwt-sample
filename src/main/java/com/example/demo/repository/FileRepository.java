package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository  extends JpaRepository<File, Long> {}