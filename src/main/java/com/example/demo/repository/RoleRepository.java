package com.example.demo.repository;

import com.example.demo.domain.Country;
import com.example.demo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Role, Long> {
    Role findById(long id);
}
