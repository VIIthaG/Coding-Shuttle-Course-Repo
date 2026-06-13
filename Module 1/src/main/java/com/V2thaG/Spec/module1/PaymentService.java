package com.V2thaG.Spec.module1;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class PaymentService {
    public void pay(){
        System.out.println("pay......");
    }
    // This annotation gets used during the bean initialization process
    @PostConstruct
    public void afterInit(){
        System.out.println("Bean Has been Constructed");
    }
    //This annotation gets used during the bean destruction process
    @PreDestroy
    public void afterDestroy() {
        System.out.println("Bean has been destroyed");
    }
}
