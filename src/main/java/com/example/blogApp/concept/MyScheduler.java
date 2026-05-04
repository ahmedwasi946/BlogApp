package com.example.blogApp.concept;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
public class MyScheduler {
    @Scheduled(fixedRate = 6000)
    @Scheduled(fixedDelay = 6000)
    @Scheduled(cron = "0 * * * * ?")
    public void runEveryMinute(){
        System.out.println("Run every minute..");
    }

    @Async
    public void  sendEmailAndCreateUser(){
        System.out.println("Async..");
    }
}
