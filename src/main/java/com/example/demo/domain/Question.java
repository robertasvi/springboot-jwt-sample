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
public class Question implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String text;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    File image;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    List<Answer> answers;
}
