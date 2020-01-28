package com.example.demo.service;

import com.example.demo.domain.SessionToken;
import com.example.demo.domain.User;
import com.example.demo.dto.UserReg;
import com.example.demo.repository.SessionTokenRepository;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    SessionTokenRepository sessionTokenRepository;

    public User save(User user) {
        return userRepository.save(verifyUserPassword(user));
    }

    private User verifyUserPassword(User user) {
        if(user.getId()!=0) {
            User existingUser = userRepository.findById(user.getId());
            user.setPassword(existingUser.getPassword());
        } else {
            user.setPassword(this.passwordEncoder.encode("password"));
        }
        return user;
    }

    public User signup(UserReg newUser) {
        User user = new User();
        user.setEmail(newUser.getEmail());
        user.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(user);
    }

    public void savePassword(String password) {
        // user.setPassword(this.passwordEncoder.encode(user.getPassword()));
    }

    public void delete(User user) {
        userRepository.delete(user);
    }

    public User findById(long id) {
        return userRepository.findById(id);
    };

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    };

    public Optional<User> findByToken(String token) {
        // Check cache
        SessionToken st = sessionTokenRepository.findByToken(token);
        return userRepository.findByEmail(st.getEmail());
    };

    public List<User> findByKeyword(String keyword) {
        return userRepository.findByKeyword(keyword);
    };

    public List<User> findAll() {
        return userRepository.findAllByOrderByIdDesc();
    };
}
