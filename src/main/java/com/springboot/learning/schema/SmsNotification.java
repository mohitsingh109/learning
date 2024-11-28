package com.springboot.learning.schema;

import org.springframework.stereotype.Component;

@Component("sms")
public class SmsNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS Message: " + message);
    }
}
