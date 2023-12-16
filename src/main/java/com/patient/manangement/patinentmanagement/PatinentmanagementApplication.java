package com.patient.manangement.patinentmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PatinentmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatinentmanagementApplication.class, args);
	}

}
