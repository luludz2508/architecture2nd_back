package com.rmit.secondsead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EntityScan({"com.rmit.secondsead"})
@EnableJpaRepositories("com.rmit.secondsead")
public class SecondseadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecondseadApplication.class, args);
	}

}
