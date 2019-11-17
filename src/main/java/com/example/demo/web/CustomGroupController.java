package com.example.demo.web;

import com.example.demo.domain.CustomGroup;
import com.example.demo.repository.CustomGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/group")
public class CustomGroupController {

    @Autowired
    CustomGroupRepository customGroupRepository;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public CustomGroup add(@RequestBody CustomGroup group) {
        return customGroupRepository.save(group);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public CustomGroup update(@RequestBody CustomGroup group) {
        return customGroupRepository.save(group);
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public List<CustomGroup> findAll() {
        return customGroupRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        CustomGroup existed = this.customGroupRepository.findById(id);
        customGroupRepository.delete(existed);
    }

}