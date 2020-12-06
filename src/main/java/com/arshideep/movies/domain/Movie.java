package com.arshideep.movies.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@NoArgsConstructor
//@RequiredArgsConstructor
public class Movie {
    public Movie(String movieName,  String movieLanguage, String genre, Integer duration) {
        this.movieName = movieName;
        this.movieLanguage = movieLanguage;
        this.genre = genre;
        this.duration = duration;
    }

    //MovieId, Movie name, movie language, movie genre, duration.
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     private String movieName;
     private String movieLanguage;
    private String genre;
     private Integer duration;

}
