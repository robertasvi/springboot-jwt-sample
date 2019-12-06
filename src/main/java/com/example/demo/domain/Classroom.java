package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Course course;
    int score;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Assignment assignment;
    Double rate;
    long created;
}
