package com.example.demo.repository;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    User findById(long id);

    List<User> findByApproved(boolean approved);

    @Query(value = "SELECT * FROM user u " +
            "JOIN role r ON r.id = u.role_id " +
            "JOIN custom_group g ON g.id = u.group_id " +
            "WHERE (u.firstname LIKE :keyword% " +
            "OR u.surname LIKE :keyword% " +
            "OR r.name LIKE :keyword% " +
            "OR g.name LIKE :keyword%)", nativeQuery = true)
    List<User> findByKeyword(@Param("keyword") String keyword);

    List<User> findAllByOrderByIdDesc();

    @Transactional
    @Modifying
    @Query(value = "UPDATE user u SET approved = 1 WHERE u.id = :id", nativeQuery = true)
    void approve(@Param("id") long id);
}
