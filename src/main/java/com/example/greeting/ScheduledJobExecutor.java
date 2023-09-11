package com.example.greeting;

import com.example.dummyBeans.GreetingsService;
import io.micronaut.context.annotation.Value;
import io.micronaut.scheduling.TaskScheduler;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.time.Duration;
import java.util.Date;

/**
 * *
 * <p>Created by irina on 11/3/2022.</p>
 * <p>Project: micronaut-sheduled-test</p>
 * *
 */
@Singleton
public class ScheduledJobExecutor {

    @Value("${user.name}")
    String user;
    private final GreetingsService greetingService;
    private final GreetingJob greetingJob;
    private final TaskScheduler taskScheduler;

    public ScheduledJobExecutor(GreetingJob greetingJob, @Named("scheduled") TaskScheduler taskScheduler, @Named("Hello") GreetingsService greetingsService) {

        this.greetingJob = greetingJob;
        this.taskScheduler = taskScheduler;
        this.greetingService = greetingsService;
    }
    public void proceed(){
        String message = greetingService.greeting();
        int hours = new Date().getHours();
        if ((hours >= 5)&(hours < 12)){message = "Good morning";} else {
            if ((hours > 18)|(hours < 5)){message = "Good night";}
        }
       scheduleGreeting(user, message);
    }
    public void scheduleGreeting(String name, String message){
        GreetingTask task = new GreetingTask(greetingJob, name, message);
        taskScheduler.schedule(Duration.ofSeconds(15), task);
    }
}
