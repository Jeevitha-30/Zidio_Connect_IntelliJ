package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "repository")
@EntityScan(basePackages = "entity")
@ComponentScan(basePackages = {"controller", "service", "security", "dto", "entity", "repository"})
@SpringBootApplication
public class ZidioApplication {

	public static void main(String[] args) {

		SpringApplication.run(ZidioApplication.class, args);
	}

}
