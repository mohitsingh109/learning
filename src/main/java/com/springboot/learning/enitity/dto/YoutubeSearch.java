package com.springboot.learning.enitity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class YoutubeSearch {

    private List<Youtube> youtubeVideos;

    private List<YoutubeChannel> youtubeChannels;
}
