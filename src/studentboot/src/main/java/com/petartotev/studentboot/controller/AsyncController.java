package com.petartotev.studentboot.controller;

import com.petartotev.studentboot.job.BackgroundAsyncJobService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    private final BackgroundAsyncJobService backgroundAsyncJobService;

    public AsyncController(BackgroundAsyncJobService backgroundAsyncJobService) {
        this.backgroundAsyncJobService = backgroundAsyncJobService;
    }

    @GetMapping("/trigger-async")
    public String triggerAsyncTask() {
        backgroundAsyncJobService.performAsyncTask();
        return "Async task triggered!";
    }
}