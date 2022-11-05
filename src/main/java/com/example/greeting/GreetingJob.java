package com.example.greeting;

import jakarta.inject.Singleton;

/**
 * *
 * <p>Created by irina on 11/3/2022.</p>
 * <p>Project: micronaut-sheduled-test</p>
 * *
 */
@Singleton
public class GreetingJob {

    public void greet(String name, String text){
        System.out.println("**********************************");
        System.out.println(text + ", " + name + "!");
        System.out.println("**********************************");
    }
}
