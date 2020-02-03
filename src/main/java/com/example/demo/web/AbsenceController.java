package com.example.demo.web;


import com.example.demo.domain.Absence;
import com.example.demo.service.AbsenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/absence")
public class AbsenceController {

    @Autowired
    AbsenceService absenceService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Absence add(@RequestBody Absence absence) {
        return absenceService.save(absence);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Absence update(@RequestBody Absence absence) {
        return absenceService.save(absence);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Absence findById(@PathVariable long id) {
        return absenceService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Absence> findAll() {
        return absenceService.findAll();
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<Absence> findByUserId(@PathVariable long id) {
        return absenceService.findByUserId(id);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Absence existed = this.absenceService.findById(id);
        absenceService.delete(existed);
    }

    @RequestMapping(value="/approve/{id}", method=RequestMethod.POST)
    @ResponseBody
    public void approve(@PathVariable long id) {
        absenceService.approve(id);
    }
}

