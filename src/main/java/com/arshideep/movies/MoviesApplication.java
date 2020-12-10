package com.arshideep.movies;

import com.arshideep.movies.domain.User;
import com.arshideep.movies.repo.MovieRepo;
import com.arshideep.movies.repo.OrderRepo;
import com.arshideep.movies.repo.TicketRepo;
import com.arshideep.movies.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class MoviesApplication {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private TicketRepo ticketRepo;

    public static void main(String[] args) {
        SpringApplication.run(MoviesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner() {
        return args -> {
            userRepo.save(new User("Harpeet","Singh","Harpeet@email.com"));
            userRepo.save(new User("Arshdip","Singh","Arshdip@email.com"));
            userRepo.save(new User("Chanchal","Tirpude","email@Tirpude.com"));
        };
    }

}
