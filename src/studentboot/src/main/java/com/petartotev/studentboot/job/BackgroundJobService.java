package com.petartotev.studentboot.job;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class BackgroundJobService {

    // Runs every 60 seconds
    @Scheduled(fixedRate = 60000) // Executes the task every 60000 milliseconds (1 minute)
    public void performBackgroundTask() {
        System.out.println("Background job is running...");
    }

    // Run at a fixed time every day (e.g., 1 AM)
    @Scheduled(cron = "0 0 1 * * ?") // Cron expression to run at 1 AM every day
    public void performDailyTask() {
        System.out.println("Daily task is running...");
    }

    // Runs after the application startup
    @Scheduled(initialDelay = 1000, fixedRate = 20000) // Starts after a 1-second delay
    public void performTaskAfterStartup() {
        System.out.println("Task started after application startup...");
    }
}