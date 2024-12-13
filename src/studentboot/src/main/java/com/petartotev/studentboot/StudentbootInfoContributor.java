package com.petartotev.studentboot;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class StudentbootInfoContributor implements InfoContributor {

    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app.name", "Student Boot")
                .withDetail("app.version", "1.0.0");
    }
}