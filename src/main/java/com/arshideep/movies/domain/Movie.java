package com.arshideep.movies.domain;

import lombok.NonNull;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String movieName;
    @NonNull private String movieLanguage;
    private String genre;
    @NonNull private Integer duration;

}
