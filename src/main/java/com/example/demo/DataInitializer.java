package com.example.demo;

import com.example.demo.domain.*;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    @Autowired
    VehicleRepository vehicles;

    @Autowired
    UserRepository users;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
//        log.debug("initializing default data...");
//        Arrays.asList("moto", "car").forEach(v -> this.vehicles.saveAndFlush(Vehicle.builder().name(v).build()));
//
//        log.debug("printing all vehicles...");
//        this.vehicles.findAll().forEach(v -> log.debug(" Vehicle :" + v.toString()));
//
//        this.users.save(User.builder()
//                .title("")
//                .firstname("")
//                .surname("")
//                .about("")
//                .group(new CustomGroup())
//                .company(new Company())
//                .address("")
//                .country(new Country())
//                .phone("")
//                .photo(new File())
//                .role(new Role())
//                .created(0)
//                .logged(0)
//                .email("user@email.com")
//                .username("user@email.com")
//                .password(this.passwordEncoder.encode("password"))
//                .roles(Arrays.asList( "ROLE_USER"))
//                .build()
//        );
//
//        this.users.save(User.builder()
//                .title("")
//                .firstname("")
//                .surname("")
//                .about("")
//                .group(new CustomGroup())
//                .company(new Company())
//                .address("")
//                .country(new Country())
//                .phone("")
//                .photo(new File())
//                .role(new Role())
//                .created(0)
//                .logged(0)
//                .email("admin@email.com")
//                .username("admin@email.com")
//                .password(this.passwordEncoder.encode("password"))
//                .roles(Arrays.asList("ROLE_USER", "ROLE_ADMIN"))
//                .build()
//        );
//
//        log.debug("printing all users...");
//        this.users.findAll().forEach(v -> log.debug(" User :" + v.toString()));
    }
}
