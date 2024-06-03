package com.example.SpringBootTutorial_JPA_PostgreSQL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootTutorialJpaPostgreSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTutorialJpaPostgreSqlApplication.class, args);
	}

}
