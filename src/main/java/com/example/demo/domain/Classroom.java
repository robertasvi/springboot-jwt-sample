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
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Type type;
    int capacity;
    String description;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Language language;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    Course course;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<User> enrolled;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Assignment> assignments;
    Double rate;
    long created;
}
