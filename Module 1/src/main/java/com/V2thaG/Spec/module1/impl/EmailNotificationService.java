package com.V2thaG.Spec.module1.impl;

import com.V2thaG.Spec.module1.NotificationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/// By the way the parent folder called "impl" basically just stands for implementations bc all the implementations of the "Notification Service" Class are stored in here

/// we are using the '  @Component ' annotation over here since we cant create objects in implementations thus use it at an actual class

//@Primary
@Component
@Qualifier("email")
//@ConditionalOnProperty(name="notification.type" ,havingValue="email")
public class EmailNotificationService implements NotificationService {

    @Override
    public void send( String message) {
        System.out.println("Email being sent: " + message);
    }
}
