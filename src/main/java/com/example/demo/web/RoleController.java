package com.example.demo.web;

import com.example.demo.domain.Role;
import com.example.demo.domain.Type;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(value="/role", method= RequestMethod.GET)
    @ResponseBody
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

}