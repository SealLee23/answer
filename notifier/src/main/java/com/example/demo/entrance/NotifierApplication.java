package com.example.demo.entrance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com")
public class NotifierApplication {
	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(NotifierApplication.class, args);
	}

}