package com.example.demo.repository;

import com.example.demo.domain.SessionToken;
import com.example.demo.domain.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SessionTokenRepository  extends JpaRepository<SessionToken, Long> {
    SessionToken findById(long id);
    SessionToken findByToken(String token);
    SessionToken findByEmail(String token);

}
