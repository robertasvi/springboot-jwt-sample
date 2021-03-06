package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    File logo;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Country country;
    String email;
    String phone;
    String web;
    boolean isApproved;
    long created;
}
