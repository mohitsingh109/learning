package com.springboot.learning.repository;

import com.springboot.learning.enitity.dto.Youtube;
import com.springboot.learning.enitity.dto.YoutubeSearch;

import java.util.List;
import java.util.Optional;

public interface YoutubeRepository {

    void save(Youtube youtube);

    YoutubeSearch findAll();

    Optional<Youtube> findById(Long id);

    void deleteById(Long id);
}
