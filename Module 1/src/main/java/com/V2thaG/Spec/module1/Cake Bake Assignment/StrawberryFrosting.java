package com.V2thaG.Spec.module1.Homework;

import org.springframework.stereotype.Component;

@Component
public class StrawberryFrosting implements Frosting {

    @Override
    public String getFrostingType(){
        return "Strawberry Frosting";
    }



}
