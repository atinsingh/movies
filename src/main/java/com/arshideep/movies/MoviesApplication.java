package com.arshideep.movies;

import com.arshideep.movies.domain.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MoviesApplication {
    private UserService service;

    public MoviesApplication(UserService service) {
        this.service = service;
    }

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            service.createUser(new User("Harpeet","Singh","email@email.com"));
            service.createUser(new User("Arshdip","Singh","email@email.com"));
        };
    }

}
