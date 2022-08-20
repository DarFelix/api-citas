package com.iudigital;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class ApiCitasApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiCitasApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(ApiCitasApplication.class, args);

		LOGGER.error("Prueba error log4j2 !!!");
		LOGGER.warn("prueba warn log4j2!");
	}

}
