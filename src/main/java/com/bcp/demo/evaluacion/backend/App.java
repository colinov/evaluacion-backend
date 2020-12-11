package com.bcp.demo.evaluacion.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.bcp.demo.evaluacion.backend.repository")
@EntityScan(basePackages = "com.bcp.demo.evaluacion.backend.repository.model")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
