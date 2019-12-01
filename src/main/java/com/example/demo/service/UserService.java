package com.example.demo.service;

import com.example.demo.domain.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    };

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    };

    public List<User> findByCompanyId(long id) {
        return userRepository.findByCompanyId(id);
    };
}