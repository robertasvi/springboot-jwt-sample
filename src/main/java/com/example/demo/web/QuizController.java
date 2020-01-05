package com.example.demo.web;

import com.example.demo.domain.Classroom;
import com.example.demo.domain.Quiz;
import com.example.demo.dto.Rate;
import com.example.demo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Quiz add(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Quiz update(@RequestBody Quiz quiz) {
        return quizService.save(quiz);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Quiz findById(@PathVariable long id) {
        return quizService.findById(id);
    }

    @RequestMapping(value="/course/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Quiz findByCourseId(@PathVariable long id) {
        return quizService.findByCourseId(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Quiz> findAll() {
        return quizService.findAll();
    }

    @RequestMapping(value="/available", method=RequestMethod.GET)
    @ResponseBody
    public List<Quiz> findByCourseIsNull() {
        return quizService.findByCourseIsNull();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Quiz existed = this.quizService.findById(id);
        quizService.delete(existed);
    }

    @RequestMapping(value="/{id}/rate", method = RequestMethod.POST)
    @ResponseBody
    public Quiz rate(@RequestBody Rate rate) {
        return quizService.rate(rate);
    }

}
