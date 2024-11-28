package com.springboot.learning.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class YoutubeController {

    private List<String> movies = new ArrayList<>();

    public YoutubeController() {
        movies.add("Movie-1");
        movies.add("Movie-2");
        movies.add("Movie-3");
    }

    //Get a Movie
    @GetMapping("/youtube/search")
    public List<String> getMovies() {
        return movies;
    }

    //Post a Movie

    //Update a Movie


    //Delete a Movie
    @DeleteMapping("/youtube/{movie}")
    public void deleteMovie(@PathVariable("movie") String movie) {
        // http://localhost:8080/youtube/{MovieName}
        movies.remove(movie);
    }
}
