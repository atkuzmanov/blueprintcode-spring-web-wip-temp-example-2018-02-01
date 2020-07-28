package com.example;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@EnableCaching
@SpringBootApplication
@EnableAutoConfiguration
@EnableSwagger2
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
