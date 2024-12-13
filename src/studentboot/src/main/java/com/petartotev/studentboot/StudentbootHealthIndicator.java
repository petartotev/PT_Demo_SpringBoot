package com.petartotev.studentboot;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class StudentbootHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.up().withDetail("Studentboot", "Running").build();
    }
}