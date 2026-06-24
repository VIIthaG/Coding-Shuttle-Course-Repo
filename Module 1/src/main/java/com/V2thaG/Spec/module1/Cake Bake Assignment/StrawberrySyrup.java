package com.V2thaG.Spec.module1.Homework;

import org.springframework.stereotype.Component;

@Component
public class StrawberrySyrup implements Syrup{

    @Override
    public String getSyrupType(){
        return "Strawberry Syrup";
    }
}

