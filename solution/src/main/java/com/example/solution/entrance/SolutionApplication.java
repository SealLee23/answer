package com.example.solution.entrance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.solution.dao.IUserRepository;

@SpringBootApplication(scanBasePackages="com")
@ComponentScan("com")
//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.example.solution.dao")
@EnableTransactionManagement
@EntityScan("com.example.solution.entity")
public class SolutionApplication {
	
	@Autowired IUserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(SolutionApplication.class, args);
	}
}
