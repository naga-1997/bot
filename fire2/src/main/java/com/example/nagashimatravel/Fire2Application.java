package com.example.nagashimatravel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Fire2Application {
	public static void main(String[] args) {
		SpringApplication.run(Fire2Application.class, args);
	}
}