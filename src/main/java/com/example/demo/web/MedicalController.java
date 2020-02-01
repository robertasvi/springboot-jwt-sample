package com.example.demo.web;

import com.example.demo.domain.Medical;
import com.example.demo.service.MedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/medical")
public class MedicalController {

    @Autowired
    MedicalService medicalService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Medical add(@RequestBody Medical med) {
        return medicalService.save(med);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Medical update(@RequestBody Medical med) {
        return medicalService.save(med);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Medical findById(@PathVariable long id) {
        return medicalService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Medical> findAll() {
        return medicalService.findAll();
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<Medical> findByUserId(@PathVariable long id) {
        return medicalService.findByUserId(id);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Medical existed = this.medicalService.findById(id);
        medicalService.delete(existed);
    }


}
