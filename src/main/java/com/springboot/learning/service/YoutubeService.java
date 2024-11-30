package com.springboot.learning.service;

import com.springboot.learning.config.AppProperties;
import com.springboot.learning.enitity.dto.Youtube;
import com.springboot.learning.enitity.dto.YoutubeSearch;
import com.springboot.learning.repository.YoutubeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class YoutubeService {

    private final YoutubeRepository youtubeRepository;

    private final AppProperties appProperties;

    @Value("${app.title:null}")
    private String title; // null

    @Value("${app.youtube.names}")
    private List<String> ignoreYoutubeVideo;

    @Value("#{${app.youtube.map}}") //SPel
    private Map<String, String> map;

    @Autowired
    public YoutubeService(YoutubeRepository youtubeRepository, AppProperties appProperties) {
        this.youtubeRepository = youtubeRepository;
        this.appProperties = appProperties;
    }

    // Get
    public YoutubeSearch getMovies() {
        System.out.println(appProperties);
        System.out.println("Title: " + title);
        System.out.println("ignoreYoutubeVideo: " + ignoreYoutubeVideo);
        System.out.println("map: " + map);
        return youtubeRepository.findAll();
    }

    // create
    public void createMovie(Youtube youtube) {
        youtubeRepository.save(youtube);
    }


    public Youtube updateMovie(Long id, Youtube updateYoutube) {
        //find the data from DB
        Optional<Youtube> optional = youtubeRepository.findById(id);

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
        youtubeRepository.deleteById(id);
    }

}
