package com.example.demo.web;

import com.example.demo.domain.SessionToken;
import com.example.demo.domain.User;
import com.example.demo.dto.UserReg;
import com.example.demo.repository.SessionTokenRepository;
import com.example.demo.security.jwt.JwtTokenProvider;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    UserService userService;

    @Autowired
    SessionTokenRepository sessionTokenRepository;

    @PostMapping("/signin")
    public ResponseEntity signin(@RequestBody AuthenticationRequest data) {

        try {
            String username = data.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, data.getPassword()));
            String token = jwtTokenProvider.createToken(username, userService.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Username " + username + "not found")).getRoles());

            SessionToken st = new SessionToken();
            st.setToken(token);
            st.setEmail(username);
            st.setCreated(9999);
            sessionTokenRepository.save(st);

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return ok(model);

        } catch (AuthenticationException e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }

    @PostMapping("/signup")
    public User signup(@RequestBody UserReg user) {
        // Check if user does not exist
        if(!userService.findByEmail(user.getEmail()).isPresent()) {
            return userService.signup(user);
        } else {
            return null;
        }
    }
}
