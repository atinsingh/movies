package com.arshideep.movies.service;

import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.exception.MovieNotFoundException;
import com.arshideep.movies.repo.MovieRepo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
   private MovieRepo movieRepo;

   public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

   public List<Movie> getAllMovies(){
        return movieRepo.findAll();
    }
   public Movie getMoviesById(Long id){
       Optional<Movie> byId = this.movieRepo.findById(id);
       if(!byId.isPresent()){
           throw new MovieNotFoundException("Request Movie"+id+"Not Avaliable");
       }else {
           return byId.get();
       }

   }
   public Movie addMovie(@RequestBody Movie movie){
        return movieRepo.save(movie);
   }
    public Movie updateMovie(@RequestBody Movie movie){
        return movieRepo.save(movie);
    }
   public void deleteMovie(@RequestBody Movie movie){
        movieRepo.delete(movie);
   }

}
