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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    String author;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    File cover;
    @Lob
    String description;
    Double version;
    boolean isSupported;
    boolean isMarketplaced;
    Double price;
    Double rate;
    @Transient
    long tutorial;
    @Transient
    long quiz;
    long created;
}
