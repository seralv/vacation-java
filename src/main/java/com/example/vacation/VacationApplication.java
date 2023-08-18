package com.example.vacation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class VacationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VacationApplication.class, args);
	}

}
