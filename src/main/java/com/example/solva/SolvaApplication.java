package com.example.solva;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients

public class SolvaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SolvaApplication.class, args);
	}

}
