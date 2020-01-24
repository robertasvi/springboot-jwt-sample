package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User save(User user) {
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    };

    public User findByToken(String token) {
        // Check cache
        return userRepository.findById(1);
    };

    public List<User> findByKeyword(String keyword) {
        return userRepository.findByKeyword(keyword);
    };

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    };
}
