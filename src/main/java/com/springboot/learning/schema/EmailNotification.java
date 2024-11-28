package com.springboot.learning.schema;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("Email Message" + message);
    }
}
