package com.example.dummyBeans;

import io.micronaut.context.annotation.Primary;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

/**
 * *
 * <p>Created by irina on 11/5/2022.</p>
 * <p>Project: micronaut-sheduled-test</p>
 * *
 */
@Named(Utils.FOO)
@Primary
@Singleton
public class DefaultGreeting implements GreetingsService {
    @Override
    public String greeting() {
        return Utils.FOO;
    }
}
