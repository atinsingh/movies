package com.arshideep.movies.controller;

import com.arshideep.movies.MovieService;
import com.arshideep.movies.UserService;
import com.arshideep.movies.domain.Movie;
import com.arshideep.movies.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Movies", description = "Movies API")
@RequestMapping("/api/")
public class MovieController {
    private MovieService service;


    public MovieController(MovieService service) {
        this.service = service;
    }


    @ApiOperation(value = "Create Movie resource", response = Movie.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Movie.class)})
    @PostMapping(value = "/movie" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Movie createMovie(@RequestBody Movie movie) {
        return service.createMoview(movie);
    }



    @ApiOperation(value = "Get all Movie resources", response = Movie.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Movie.class)})
    @GetMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getAllMovies() {
        return this.service.getAllMovies();

    }



    @ApiOperation(value = "Finds Movie by id", response = Movie.class)
    @ApiResponses(value = {@ApiResponse(code = 200, message = "successful operation", response = Movie.class), @ApiResponse(code = 404, message = "Movie respurce does not exists") })
    @GetMapping(value = "/movie/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieById(@PathVariable("id") Long id) {
        return this.service.getMovieById(id);
    }



    @ApiOperation(value = "Delete movie ", response = Movie.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation"),
            @ApiResponse(code = 404, message = "Movie resource does not exists") })
    @DeleteMapping(value = "/movie", produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteMovie(@RequestBody Movie movie) {
        this.service.deleteMoview(movie);
    }




    @ApiOperation(value = "Update Movie resource", response = Movie.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "successful operation", response = Movie.class)})

    @PutMapping(value = "/movie" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public Movie updateMovie(@RequestBody Movie movie) {
        return service.createMoview(movie);
    }

}
