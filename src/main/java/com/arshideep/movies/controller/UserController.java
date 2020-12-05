package com.arshideep.movies.controller;

import com.arshideep.movies.UserService;
import com.arshideep.movies.domain.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping(value = "/user" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        return this.service.createUser(user);
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return this.service.getAllUsers();
    }
}
