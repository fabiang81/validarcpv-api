package com.multiva.cecoban.validarcpv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CecobanValidarCpvServiceApplication extends SpringBootServletInitializer{//
	
	//configuration for deploying a war file
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CecobanValidarCpvServiceApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CecobanValidarCpvServiceApplication.class, args);
	}
}
