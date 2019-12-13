package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @CachePut(value = "user", key = "#user.id")
    public User save(User user) {
        return userRepository.save(user);
    }

    @CacheEvict(value = "user", key = "#user.id")
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Cacheable(value = "user", key = "#id")
    public User findById(long id) {
        return userRepository.findById(id);
    };

    public List<User> findByKeyword(String keyword) {
        return userRepository.findByKeyword(keyword);
    };

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    };

    public List<User> findByCompanyId(long id) {
        return userRepository.findByCompanyId(id);
    };
}
