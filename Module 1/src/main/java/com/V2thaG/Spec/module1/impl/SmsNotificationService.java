package com.V2thaG.Spec.module1.impl;

import com.V2thaG.Spec.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

/// By the way the parent folder called "impl" basically just stands for implementations bc all the implementations of the "Notification Service" Class are stored in here

@Component
@Qualifier("sms")
//@ConditionalOnProperty(name="notification.type" ,havingValue="sms")
public class SmsNotificationService implements NotificationService {

    @Override
    public void send( String message) {
        System.out.println("SMS being sent: " + message);
    }
}
