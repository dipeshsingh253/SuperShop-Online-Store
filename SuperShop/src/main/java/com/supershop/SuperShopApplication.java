package com.supershop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Runner class for this project
 * This class is entry point for this project.
 */

@SpringBootApplication
@EnableSwagger2
public class SuperShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(SuperShopApplication.class, args);
	}

}
