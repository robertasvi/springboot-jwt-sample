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
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Language language;
    String author;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    File cover;
    String description;
    Double version;
    boolean isSupported;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Tutorial tutorial;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Quiz quiz;
    Double price;
    Double rate;
    long created;
}
