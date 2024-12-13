package com.petartotev.studentboot.job;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class BackgroundAsyncJobService {
    @Async
    public void performAsyncTask() {
        System.out.println("Async task is running...");
    }
}
