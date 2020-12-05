package com.arshideep.movies;

import com.arshideep.movies.domain.User;
import com.arshideep.movies.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
