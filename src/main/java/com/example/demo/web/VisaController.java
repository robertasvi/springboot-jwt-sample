package com.example.demo.web;

import com.example.demo.domain.Visa;
import com.example.demo.service.VisaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/visa")
public class VisaController {

    @Autowired
    VisaService visaService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Visa add(@RequestBody Visa visa) {
        return visaService.save(visa);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Visa update(@RequestBody Visa visa) {
        return visaService.save(visa);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Visa findById(@PathVariable long id) {
        return visaService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Visa> findAll() {
        return visaService.findAll();
    }

    @RequestMapping(value="/user/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<Visa> findByUserId(@PathVariable long id) {
        return visaService.findByUserId(id);
    }


    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Visa existed = this.visaService.findById(id);
        visaService.delete(existed);
    }


}
