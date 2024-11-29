package com.springboot.learning.service;

import com.springboot.learning.enitity.dto.Youtube;
import com.springboot.learning.enitity.dto.YoutubeChannel;
import com.springboot.learning.enitity.dto.YoutubeSearch;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class YoutubeService {

    String userName = "sljfdskljfs"; // security??

    private List<String> movies = new ArrayList<>();

    private List<Youtube> youtubesVideos = new ArrayList<>();

    private List<YoutubeChannel> youtubeChannels = new ArrayList<>();

    public YoutubeService() {
        youtubesVideos.add(new Youtube(1L, "1", "Avangers", LocalDate.now(), 1000, "description-1"));
        youtubesVideos.add(new Youtube(2L,"2","Java", LocalDate.now(), 100, "description-2"));
        youtubesVideos.add(new Youtube(3L,"2","Python", LocalDate.now(), 2000, "description-3"));
        youtubeChannels.add(new YoutubeChannel("1", "ABC"));
        youtubeChannels.add(new YoutubeChannel("2", "XYZ"));
    }

    // Get
    public YoutubeSearch getMovies() {
        return new YoutubeSearch(youtubesVideos, youtubeChannels); // data fetch operation
    }

    // create
    public void createMovie(Youtube youtube) {
        youtubesVideos.add(youtube); // data insert operation
    }


    public Youtube updateMovie(Long id, Youtube updateYoutube) {
        //find the data from DB
        Optional<Youtube> optional = youtubesVideos.stream() // data-query
                .filter(y -> y.getId().equals(id))
                .findFirst();

        //validate if data exist
        if(optional.isEmpty()) {
            throw new RuntimeException("Video not found with id: " + id);
        }

        Youtube youtube = optional.get(); // oldData

        // check if user has updated the name field
        if(updateYoutube.getName() != null) {
            // yes then update the data
            youtube.setName(updateYoutube.getName());
        }

        // check if user has updated the description field
        if(updateYoutube.getDescription() != null) {
            // yes then update the data
            youtube.setDescription(updateYoutube.getDescription());
        }

        return youtube;
    }

    // delete
    public void deleteMovie(Long id) {
        //find the video
        Optional<Youtube> optional = youtubesVideos.stream()
                .filter(y -> y.getId().equals(id))
                .findFirst();

        //delete the video
        optional.ifPresent(y -> youtubesVideos.remove(y));
    }

}
