package com.jsp.ums.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
@OpenAPIDefinition
public class ApplicationDocumentation {

	Contact contact() {
		return new Contact().email("kalabdpura@gmial.com")
				.url("abc.xyz.in")
				.email("abc");
		}
	
	Info info() {
		return new Info().title("user management system API")
				.version("1.0v")
				.description("user managemnet system is a Restfull API built using"
						+"Spring boot and MySQL database")
				.contact(contact());
	}
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}
}


