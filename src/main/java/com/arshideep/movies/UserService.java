package com.arshideep.movies;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.User;
import com.arshideep.movies.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepo repo;

    public UserService(UserRepo repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
                return this.repo.save(user);
    }

    public List<User> getAllUsers() {
        return this.repo.findAll();
    }

    public Optional<User> getUserById(Long id){
        return repo.findById(id);

    }

    public void deleteUser(User user){
        repo.delete(user);
    }

    public User updateUser(User user) {
        if(repo.findById(user.getUserId()).isPresent())
        return this.repo.save(user);
        else return null;
    }

}
