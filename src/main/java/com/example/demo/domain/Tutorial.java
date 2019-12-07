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
public class Tutorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Course course;
    String name;
    String description;
    Double version;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Material> materials;
    Double rate;
    long created;
}
