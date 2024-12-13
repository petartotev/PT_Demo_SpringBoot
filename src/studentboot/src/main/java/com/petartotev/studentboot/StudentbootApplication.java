package com.petartotev.studentboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling /* https://github.com/petartotev/PT_Demo_SpringBoot?tab=readme-ov-file#synchronous-processing */
@EnableAsync      /* https://github.com/petartotev/PT_Demo_SpringBoot?tab=readme-ov-file#asynchronous-processing */
public class StudentbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentbootApplication.class, args);
	}

}
