package com.example.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Transactional
public class Tutorial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String name;
    String description;
    Double version;
    @ManyToOne(fetch = FetchType.EAGER)
    Language language;
    @ManyToOne(fetch = FetchType.EAGER)
    Level level;
    @ManyToOne(fetch = FetchType.EAGER)
    Type type;
    @OneToMany(fetch = FetchType.LAZY)
    Set<Material> material;
    Double rate;
    long created;
}
