package com.example.demo.web;

import com.example.demo.domain.Classroom;
import com.example.demo.domain.Enrolled;
import com.example.demo.dto.Rate;
import com.example.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/classroom")
public class ClassroomController {

    @Autowired
    ClassroomService classroomService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Classroom add(@RequestBody Classroom classroom) {
        return classroomService.save(classroom);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Classroom update(@RequestBody Classroom classroom) {
        return classroomService.save(classroom);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Classroom findById(@PathVariable long id) {
        return classroomService.findById(id);
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<Classroom> findByUserId(@PathVariable long id) {
        return classroomService.findByUserId(id);
    }

    @RequestMapping(value="/enrolled/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Enrolled findByEnrolledId(@PathVariable long id) {
        return classroomService.findByClassroomId(id);
    }


    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Classroom> findAll() {
        return classroomService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Classroom existed = this.classroomService.findById(id);
        classroomService.delete(existed);
    }

    @RequestMapping(value="/enrolled/{id}/count", method=RequestMethod.GET)
    @ResponseBody
    public long countEnrolledUsers(@PathVariable long id) {
        return classroomService.countEnrolledUsers(id);
    }

    @RequestMapping(value="/{id}/rate", method = RequestMethod.POST)
    @ResponseBody
    public Classroom rate(@RequestBody Rate rate) {
        return classroomService.rate(rate);
    }

}
