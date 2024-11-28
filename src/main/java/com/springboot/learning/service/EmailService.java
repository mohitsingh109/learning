package com.springboot.learning.service;

import com.springboot.learning.schema.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service // Bean will be created
public class EmailService {

    private final Notification notification;

    @Autowired
    public EmailService(@Qualifier("email") Notification notification) {
        this.notification = notification;
    }
}
