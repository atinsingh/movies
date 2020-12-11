package com.arshideep.movies.controller;
import com.arshideep.movies.domain.User;
import com.arshideep.movies.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
   private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    public List<User> getAllUsers(){
        return  userService.getAllUsers();
    }
    @GetMapping("/id")
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) { return userService.updateUser(user);}

    @DeleteMapping
    public void deleteUser(@RequestBody User user){ userService.deleteuser(user);}


}
