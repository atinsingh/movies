package com.arshideep.movies.service;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.User;
import com.arshideep.movies.exception.MovieNotFoundException;
import com.arshideep.movies.exception.UserNotFoundException;
import com.arshideep.movies.repo.MovieRepo;
import com.arshideep.movies.repo.UserRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public User getUserById(Long id){
        Optional<User> byId = this.userRepo.findById(id);
        if(!byId.isPresent()){
            throw new UserNotFoundException("Requested User"+id+"Not Avaliable");
        }else {
            return byId.get();
        }
    }
    public User addUser(@RequestBody User user){
        return userRepo.save(user);
    }

    public User updateUser(@RequestBody User user){ return userRepo.save(user);}

    public void deleteuser(@RequestBody User user) { userRepo.delete(user);}

}
