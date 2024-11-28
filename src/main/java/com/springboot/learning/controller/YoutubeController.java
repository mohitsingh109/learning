package com.springboot.learning.controller;

import com.springboot.learning.enitity.dto.Youtube;
import com.springboot.learning.enitity.dto.YoutubeSearch;
import com.springboot.learning.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class YoutubeController {

    private final YoutubeService youtubeService;

    @Autowired
    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    //Get a Movie
    @GetMapping("/youtube/search")
    public YoutubeSearch getMovies() {
        System.out.println("Thread Name: " + Thread.currentThread().getName());
        return youtubeService.getMovies();
    }

    //Post a Movie
    @PostMapping("/youtube/{movie}")
    public void createMovie(@PathVariable("movie") String movie) {
        youtubeService.createMovie(movie);
    }

    //Update a Movie
    @PutMapping("/youtube/{oldMovie}/{newMovie}")
    public void updateMovie(@PathVariable("oldMovie") String oldMovie, @PathVariable("newMovie") String newMovie) {
       youtubeService.updateMovie(oldMovie, newMovie);
    }

    //Delete a Movie
    @DeleteMapping("/youtube/{movie}")
    public void deleteMovie(@PathVariable("movie") String movie) {
       youtubeService.deleteMovie(movie);
    }

//    @PatchMapping("/youtube/patch")
//    public void performPatch() {
//
//    }
}
