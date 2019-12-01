package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Classroom implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String description;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Course course;
    int score;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<User> enrolled;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Assignment> assignments;
    Double rate;
    long created;
}
