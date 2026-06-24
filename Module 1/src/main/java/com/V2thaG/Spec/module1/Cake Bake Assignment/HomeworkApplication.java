package com.V2thaG.Spec.module1.Homework;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkApplication implements CommandLineRunner {

    private final CakeBaker cakeBaker;

    public HomeworkApplication(CakeBaker cakeBaker) {
        this.cakeBaker = cakeBaker;
    }

    public static void main(String[] args) {
        SpringApplication.run(HomeworkApplication.class, args);
    }

    @Override
    public void run(String... args) {
        cakeBaker.bakeCake();
    }
}