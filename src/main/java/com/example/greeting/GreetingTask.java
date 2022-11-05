package com.example.greeting;

/**
 * *
 * <p>Created by irina on 11/3/2022.</p>
 * <p>Project: micronaut-sheduled-test</p>
 * *
 */

public class GreetingTask implements Runnable {
    private final GreetingJob greetingJob;
    private final String name;
    private final String message;

    public GreetingTask(GreetingJob greetingJob, String name, String message) {

        this.greetingJob = greetingJob;
        this.name = name;
        this.message = message;
    }


    @Override
    public void run() {
        greetingJob.greet(name,message);
    }
}
