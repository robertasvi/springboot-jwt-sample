package com.example.demo.web;

import com.example.demo.domain.Role;
import com.example.demo.domain.Type;
import com.example.demo.domain.User;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleRepository roleRepository;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public Role add(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public Role update(@RequestBody Role role) {
        return roleRepository.save(role);
    }

    @RequestMapping(method= RequestMethod.GET)
    @ResponseBody
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        Role existed = this.roleRepository.findById(id);
        roleRepository.delete(existed);
    }

}