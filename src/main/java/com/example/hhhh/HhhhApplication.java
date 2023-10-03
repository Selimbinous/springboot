package com.example.hhhh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HhhhApplication {

	public static void main(String[] args) {
		SpringApplication.run(HhhhApplication.class, args);
	}

}
