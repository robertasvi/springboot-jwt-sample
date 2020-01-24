package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findById(long id);

    @Query(value = "SELECT * FROM user u " +
            "JOIN role r ON r.id = u.role_id " +
            "JOIN custom_group g ON g.id = u.group_id " +
            "WHERE (u.firstname LIKE :keyword% " +
            "OR u.surname LIKE :keyword% " +
            "OR r.name LIKE :keyword% " +
            "OR g.name LIKE :keyword%)", nativeQuery = true)
    List<User> findByKeyword(@Param("keyword") String keyword);

    List<User> findAllByOrderByIdDesc();
}
