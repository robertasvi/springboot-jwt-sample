package com.example.demo.domain;

import java.util.List;

public class Quiz {
    int id;
    String name;
    String description;
    Double version;
    Type type;
    Language language;
    Level level;
    int score;
    List<Question> questions;
    Double rate;
    long created;
}
