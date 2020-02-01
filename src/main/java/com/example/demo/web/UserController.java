package com.example.demo.web;

import com.example.demo.domain.User;
import com.example.demo.domain.Vehicle;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    /*
    ALL METHODS, ESPECIALLY THAT UPDATES OR SAVES DATA, MUST HAVE TOKEN AUTHORIZATION MODEL
     */
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

    @RequestMapping(value="/approval", method=RequestMethod.GET)
    @ResponseBody
    public List<User> findNotApproved() {
        return userService.findByApproved(false);
    }

    @RequestMapping(value="/approve/{id}", method=RequestMethod.POST)
    @ResponseBody
    public void approve(@PathVariable long id) {
        userService.approve(id);
    }


    @RequestMapping(value="/profile", method=RequestMethod.GET)
    @ResponseBody
    public Optional<User> findByToken(@RequestHeader(value="token") String token) {
        return userService.findByToken(token);
    }


    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<User> findByApproved() { return userService.findByApproved(true); }

    @RequestMapping(value="/search/{keyword}", method=RequestMethod.GET)
    @ResponseBody
    public List<User> findByKeyword(@PathVariable String keyword) {
        return userService.findByKeyword(keyword);
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    @ResponseBody
    public void delete(@PathVariable long id) {
        User existed = this.userService.findById(id);
        userService.delete(existed);
    }
}
