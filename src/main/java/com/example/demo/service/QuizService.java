package com.example.demo.service;

import com.example.demo.domain.Quiz;
import com.example.demo.dto.Rate;
import com.example.demo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    QuizRepository quizRepository;

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void delete(Quiz quiz) {
        quizRepository.delete(quiz);
    }

    public Quiz findById(long id) {
        return quizRepository.findById(id);
    };

    public Quiz findByCourseId(long id) {
        return quizRepository.findByCourseId(id);
    };

    public List<Quiz> findAll() {
        return quizRepository.findAllByOrderByIdDesc();
    };

    public List<Quiz> findByCourseIsNull() {
        return quizRepository.findByCourseIsNull();
    };

    public Quiz rate(Rate rate) {
        return quizRepository.rate(rate.getSourceId(), rate.getValue());
    }
}
