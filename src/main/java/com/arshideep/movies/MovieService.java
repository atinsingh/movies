package com.arshideep.movies;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.User;
import com.arshideep.movies.repo.MovieRepo;
import com.arshideep.movies.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MovieService {
    @Autowired
    private MovieRepo repo;


    public Movie createMoview(Movie movie) {
        return this.repo.save(movie);
    }

    public List<Movie> getAllMovies() {
        return this.repo.findAll();
    }

    public Movie getMovieById(Long id){
        return repo.findById(id).orElseThrow(()->new RuntimeException("Movie Not Found"));
    }

    public void deleteMoview(Movie movie){
        repo.delete(movie);
    }
}

