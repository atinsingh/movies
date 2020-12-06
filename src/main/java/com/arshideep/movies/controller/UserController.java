package com.arshideep.movies.controller;

import com.arshideep.movies.UserService;
import com.arshideep.movies.domain.TicketInventory;
import com.arshideep.movies.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/")

@Api(value = "Users", description = "Users API")
public class UserController {
    private UserService service;


    public UserController(UserService service) {
        this.service = service;
    }

    @ApiOperation(value = "Create User resource", response = User.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = User.class)})
    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User createUser(@RequestBody User user) {
        return this.service.createUser(user);
    }


    @ApiOperation(value = "Get all User resources", response = User.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = User.class)})
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<User> getUsers() {
        return this.service.getAllUsers();
    }


    @ApiOperation(value = "Finds User by id", response = User.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = User.class), @ApiResponse(code = 404, message = "User respurce does not exists")})
    @GetMapping(value = "/user/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public User getUserById(@PathVariable("id") Long id) {
        Optional<User> user = service.getUserById(id);
        if (user.isPresent()) return user.get();
        else return null;
    }


    @ApiOperation(value = "Delete User ", response = User.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "User resource does not exists")})
    @DeleteMapping(value = "/user")
    public void deleteUser(@RequestBody User user) {
        this.service.deleteUser(user);
    }


    @ApiOperation(value = "Update User resource", response = User.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = User.class)})
    @PutMapping(value = "/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        return this.service.createUser(user);
    }

}
