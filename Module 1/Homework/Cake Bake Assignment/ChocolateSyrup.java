package com.V2thaG.Spec.module1.Homework;

import org.springframework.stereotype.Component;

@Component
public class ChocolateSyrup implements Syrup{

    @Override
    public String getSyrupType(){
        return "Chocolate Syrup";
    }
}
