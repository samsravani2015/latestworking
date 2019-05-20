package com.example.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaOneToManyDemoApplication {
	public static void main(String[] args) {
		System.out.println("VIGNESwara swamy");
		SpringApplication.run(JpaOneToManyDemoApplication.class, args);
	}
}
