package com.springboot.learning.controller;

import com.springboot.learning.enitity.dto.Youtube;
import com.springboot.learning.enitity.dto.YoutubeSearch;
import com.springboot.learning.service.YoutubeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/youtube") // It will add to all the request
public class YoutubeController {

    private final YoutubeService youtubeService;

    @Autowired
    public YoutubeController(YoutubeService youtubeService) {
        this.youtubeService = youtubeService;
    }

    //Get a Movie
    @GetMapping("/search")
    public ResponseEntity<YoutubeSearch> getMovies() {
        // new ResponseEntity(youtubeService.getMovies(), HttpStats.OK)
        return ResponseEntity.ok(youtubeService.getMovies());
    }

    //Post a Movie

    /**
     * {
     *     "channelId": "2",
     *     "name": "Spring boot",
     *     "uploadDate": "2024-01-01",
     *     "duration": 5000,
     *     "description": "THis is Spring boot tutorial"
     * }
     */
    @PostMapping()
    public ResponseEntity<String> createMovie(@RequestBody Youtube youtube) {
        youtubeService.createMovie(youtube);
        return ResponseEntity.created(URI.create("ok")).build();
    }

    //Update a Movie
    @PutMapping("/{id}")
    public ResponseEntity<Youtube> updateMovie(@PathVariable("id") Long id, @RequestBody Youtube youtube) {
       return ResponseEntity.ok(youtubeService.updateMovie(id, youtube));
    }

    //Delete a Movie
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable("id") Long id) {
       youtubeService.deleteMovie(id);
    }
}
