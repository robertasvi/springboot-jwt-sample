package com.example.demo.domain;

import java.util.List;

public class Classroom {
    int id;
    String name;
    Type type;
    int capacity;
    String description;
    Language language;
    Course course;
    List<User> enrolled;
    List<Assignment> assignments;
    Double rate;
    long created;
}
