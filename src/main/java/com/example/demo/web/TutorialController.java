package com.example.demo.web;

import com.example.demo.domain.Tutorial;
import com.example.demo.service.TutorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/tutorial")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Tutorial add(@RequestBody Tutorial tutorial) {
        return tutorialService.save(tutorial);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Tutorial update(@RequestBody Tutorial tutorial) {
        return tutorialService.save(tutorial);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Tutorial findById(@PathVariable long id) {
        return tutorialService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<Tutorial> findAll() {
        return tutorialService.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Tutorial existed = this.tutorialService.findById(id);
        tutorialService.delete(existed);
    }
}
