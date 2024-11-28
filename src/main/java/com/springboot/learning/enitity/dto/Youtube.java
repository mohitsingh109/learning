package com.springboot.learning.enitity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Youtube {

    private String channelId;

    private String name;

    public LocalDate uploadDate;

    public Integer duration;

    public String description;

    //...
}
