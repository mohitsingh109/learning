package com.springboot.learning.service;

import com.springboot.learning.enitity.dto.Youtube;
import com.springboot.learning.enitity.dto.YoutubeChannel;
import com.springboot.learning.enitity.dto.YoutubeSearch;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class YoutubeService {

    String userName = "sljfdskljfs"; // security??

    private List<String> movies = new ArrayList<>();

    private List<Youtube> youtubesVideos = new ArrayList<>();

    private List<YoutubeChannel> youtubeChannels = new ArrayList<>();

    public YoutubeService() {
        youtubesVideos.add(new Youtube("1", "Avangers", LocalDate.now(), 1000, "description-1"));
        youtubesVideos.add(new Youtube("2","Java", LocalDate.now(), 100, "description-2"));
        youtubesVideos.add(new Youtube("2","Python", LocalDate.now(), 2000, "description-3"));
        youtubeChannels.add(new YoutubeChannel("1", "ABC"));
        youtubeChannels.add(new YoutubeChannel("2", "XYZ"));
    }

    // Get
    public YoutubeSearch getMovies() {
        return new YoutubeSearch(youtubesVideos, youtubeChannels);
    }

    // create
    public void createMovie(String movie) {
        movies.add(movie);
    }

    // update
    // user1 --> Movie_Old, Movie_New
    // user2 --> Movie_Old, Movie_New_1
    public void updateMovie(String oldMovie, String newMovie) {
        movies.remove(oldMovie);
        movies.add(newMovie);
    }

    // delete
    public void deleteMovie(String movie) {
        movies.remove(movie);
    }

}
