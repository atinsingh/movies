package com.arshideep.movies;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.Order;
import com.arshideep.movies.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
@EnableDiscoveryClient
public class MoviesApplication {
    @Autowired
    private UserService uservice;
    @Autowired
    private MovieService mservice;

    @Autowired private OrderService oservice;


    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            User user1 = new User("Harpeet", "Singh", "email@email.com");
            uservice.createUser(user1);
            uservice.createUser(new User("Arshdip","Singh","email@email.com"));
            Movie movie = new Movie("DDLJ", "DRAMA", "eNGLISH", 3);
            mservice.createMoview(movie);
            oservice.createOrder(new Order(user1,movie,new Date()));

        };
    }

}
