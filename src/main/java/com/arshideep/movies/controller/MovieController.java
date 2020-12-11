package com.arshideep.movies.controller;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.service.MovieService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movie")
public class MovieController {
    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    public List<Movie> getAllMovies(){
        return  movieService.getAllMovies();
    }
    @GetMapping("/id")
    public Movie getMovieById(@PathVariable Long id){
        return movieService.getMoviesById(id);
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie){
        return movieService.addMovie(movie);
    }

    @PutMapping
    public Movie updateMovie(@RequestBody Movie movie) { return movieService.updateMovie(movie);}

    @DeleteMapping
    public void deleteMovie(@RequestBody Movie movie) { movieService.deleteMovie(movie); }



}
