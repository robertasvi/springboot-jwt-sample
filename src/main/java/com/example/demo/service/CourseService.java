package com.example.demo.service;

import com.example.demo.domain.Course;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.QuizRepository;
import com.example.demo.repository.TutorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    TutorialRepository tutorialRepository;

    @Autowired
    QuizRepository quizRepository;

    @Transactional
    public Course save(Course course) {
        Course saved = courseRepository.save(course);

        tutorialRepository.removeCourse(saved.getId());
        tutorialRepository.updateTutorialCourse(saved.getId(), course.getTutorial());

        quizRepository.removeCourse(saved.getId());
        quizRepository.updateQuizCourse(saved.getId(), course.getQuiz());

        return saved;
    }

    @Transactional
    public void delete(Course course) {
        tutorialRepository.removeCourse(course.getId());
        quizRepository.removeCourse(course.getId());
        courseRepository.delete(course);
    }

    public Course findById(long id) {
        return courseRepository.findById(id);
    };

    public List<Course> findAll() {
        return courseRepository.findAllByOrderByIdDesc();
    };
}
