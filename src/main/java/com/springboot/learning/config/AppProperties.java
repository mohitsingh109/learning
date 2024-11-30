package com.springboot.learning.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app.v1")
@Getter
@Setter
@ToString
public class AppProperties {

    private String name;

    private String version;

}
