package com.V2thaG.Spec.module1.Homework;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CakeBaker {

    private Frosting frosting;
    private Syrup syrup;

    public CakeBaker(
            @Qualifier("chocolateFrosting") Frosting frosting,
            @Qualifier("strawberrySyrup") Syrup syrup
    ) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake() {
        System.out.println(
                frosting.getFrostingType() + " and " +
                        syrup.getSyrupType()
        );
    }
}