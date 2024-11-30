package com.springboot.learning.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//sourcing the file
@Configuration
@PropertySource("classpath:config.properties")
public class AppPropertiesWithConfigFile {
}
