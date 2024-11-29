package com.springboot.learning.enitity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString // print all the details of youtube object
public class Youtube {

    private Long id; // PK

    private String channelId;

    private String name; // update

    public LocalDate uploadDate;

    public Integer duration;

    public String description; // update

}
