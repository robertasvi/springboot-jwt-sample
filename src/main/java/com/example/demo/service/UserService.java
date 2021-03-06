package com.example.demo.service;

import com.example.demo.domain.CustomGroup;
import com.example.demo.domain.Role;
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
        return userRepository.save(verifyUserPasswordAndApproval(user));
    }

    public void approve(long id) {
        userRepository.approve(id);
    }

    private User verifyUserPasswordAndApproval(User user) {
        if(user.getId()!=0) {
            User existingUser = userRepository.findById(user.getId());
            user.setPassword(existingUser.getPassword());
            user.setApproved(existingUser.isApproved());
        } else {
            user.setPassword(this.passwordEncoder.encode("P@ssw0rd"));
        }
        return user;
    }

    public User signup(UserReg newUser) {
        User user = new User();
        user.setFirstname(newUser.getFirstname());
        user.setSurname(newUser.getSurname());
        user.setEmail(newUser.getEmail());
        user.setPhone(newUser.getPhone());
        user.setPassword(this.passwordEncoder.encode(newUser.getPassword()));
        user.setGroup(new CustomGroup(1));
        user.setRole(new Role(1));
        user.setSysRole("USER");
        user.setApproved(false);
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

    public List<User> findByApproved(boolean approved) {
        return userRepository.findByApproved(approved);
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
