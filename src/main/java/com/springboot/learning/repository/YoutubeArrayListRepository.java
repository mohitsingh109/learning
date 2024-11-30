package com.springboot.learning.repository;

import com.springboot.learning.enitity.dto.Youtube;
import com.springboot.learning.enitity.dto.YoutubeChannel;
import com.springboot.learning.enitity.dto.YoutubeSearch;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class YoutubeArrayListRepository implements YoutubeRepository {

    // Database
    private final List<Youtube> youtubeVideos = new ArrayList<>();
    private final List<YoutubeChannel> youtubeChannels = new ArrayList<>();

    public YoutubeArrayListRepository() {
        youtubeVideos.add(new Youtube(1L, "1", "Avangers", LocalDate.now(), 1000, "description-1"));
        youtubeVideos.add(new Youtube(2L,"2","Java", LocalDate.now(), 100, "description-2"));
        youtubeVideos.add(new Youtube(3L,"2","Python", LocalDate.now(), 2000, "description-3"));
        youtubeChannels.add(new YoutubeChannel("1", "ABC"));
        youtubeChannels.add(new YoutubeChannel("2", "XYZ"));
    }

    @Override
    public void save(Youtube youtube) {
        youtubeVideos.add(youtube);
    }

    @Override
    public YoutubeSearch findAll() {
        return new YoutubeSearch(youtubeVideos, youtubeChannels);
    }

    @Override
    public Optional<Youtube> findById(Long id) {
        return youtubeVideos.stream()
                .filter(youtube -> youtube.getId().equals(id))
                .findFirst();
    }

    @Override
    public void deleteById(Long id) {
        Optional<Youtube> optionalYoutube = findById(id);
        optionalYoutube.ifPresent(youtube -> youtubeVideos.remove(youtube));
    }
}
