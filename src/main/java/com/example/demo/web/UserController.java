package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.domain.Vehicle;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public User add(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public User update(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public User findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<User> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value="/company/{id}", method=RequestMethod.GET)
    @ResponseBody
    public List<User> findByCompanyId(@PathVariable long id) {
        return userService.findByCompanyId(id);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        User existed = this.userService.findById(id);
        userService.delete(existed);
    }
}
