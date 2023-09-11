package com.example;

import com.example.greeting.ScheduledJobExecutor;
import io.micronaut.runtime.Micronaut;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.runtime.server.event.ServerStartupEvent;
import io.micronaut.scheduling.annotation.Async;
import jakarta.inject.Singleton;

@Singleton
public class Application {


    private final ScheduledJobExecutor scheduledJobExecutor;

    public Application(ScheduledJobExecutor scheduledJobExecutor) {

        this.scheduledJobExecutor = scheduledJobExecutor;
    }

    public static void main(String[] args) {
        Micronaut.run(Application.class, args);
    }

    @EventListener
    @Async
    public void onStartup(ServerStartupEvent event) {
        System.out.println("**********************************");
        System.out.println("started!");
        System.out.println("**********************************");
        scheduledJobExecutor.proceed();

    }
}
