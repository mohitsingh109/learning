package com.springboot.learning.config;

import com.springboot.learning.schema.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // we are tell this class can create some @Bean
public class AppConfig {


    @Bean("person")
    @Scope("prototype")// tell spring create new object every time
    public Person person() { // once this function will run
        return new Person("Test Person");
    }

    //...

}
