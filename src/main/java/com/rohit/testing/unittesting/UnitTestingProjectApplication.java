package com.rohit.testing.unittesting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.rohit.testing.unittesting.*"})
@EnableJpaRepositories("com.rohit.testing.unittesting.repository")
public class UnitTestingProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(UnitTestingProjectApplication.class, args);
	}

}
