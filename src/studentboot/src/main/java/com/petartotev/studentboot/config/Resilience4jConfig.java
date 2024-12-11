package com.petartotev.studentboot.config;

import io.github.resilience4j.retry.Retry;
import io.github.resilience4j.retry.RetryConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jConfig {
    @Value("${resilience4j.retry.carRepository.maxAttempts:3}") // Default value is 3 if not specified
    private int maxAttempts;
    @Value("${resilience4j.retry.carRepository.waitDuration:2000}") // Default value is 2000 ms if not specified
    private long waitDuration;

    @Bean
    public Retry retryConfig() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(maxAttempts) // Retry 3 times
                .waitDuration(Duration.ofMillis(waitDuration)) // Wait 2 seconds between retries
                .build();

        Retry retry = Retry.of("carRepository", config);

        // Add event listener to log retry attempts
        retry.getEventPublisher()
                .onRetry(event -> System.out.println("Retry attempt #" + event.getNumberOfRetryAttempts()
                        + " for " + event.getName()));

        return retry;
    }
}