package com.example.jokebot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.jokebot.repository")
@EntityScan(basePackages = "com.example.jokebot.model")
public class JokebotApplication {
	public static void main(String[] args) {
		SpringApplication.run(JokebotApplication.class, args);
	}
}
