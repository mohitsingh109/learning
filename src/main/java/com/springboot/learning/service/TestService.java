package com.springboot.learning.service;

import com.springboot.learning.schema.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service // please create a bean
public class TestService {

    private final Person person;

    @Autowired
    public TestService(Person person) {
        this.person = person;
        System.out.println("Service = " + person);
    }
}
