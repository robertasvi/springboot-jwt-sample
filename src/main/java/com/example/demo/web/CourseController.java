package com.example.demo.web;

import com.example.demo.domain.Course;
import com.example.demo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Course add(@RequestBody Course course) {
        return courseService.save(course);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Course update(@RequestBody Course course) {
        return courseService.save(course);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Course findById(@PathVariable long id) {
        return courseService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Course existed = this.courseService.findById(id);
        courseService.delete(existed);
    }
}
