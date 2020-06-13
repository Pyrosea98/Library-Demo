package com.desarrollo.biblioteca;

import com.desarrollo.biblioteca.BibliotecaMunicipalApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(BibliotecaMunicipalApplication.class);
	}

}
