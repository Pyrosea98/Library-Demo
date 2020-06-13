package com.desarrollo.biblioteca;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "com.desarrollo.biblioteca.modelo")
public class BibliotecaMunicipalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaMunicipalApplication.class, args);
	}

}
