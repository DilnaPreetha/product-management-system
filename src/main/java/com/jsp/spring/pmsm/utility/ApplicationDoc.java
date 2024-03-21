package com.jsp.spring.pmsm.utility;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration

@OpenAPIDefinition
public class ApplicationDoc {
	Contact contact() {
		return new Contact().name("anu")
				.url("xyz.in")
				.email("anu@eamil.com");
	}
		
		
		@Bean
		Info info() {
			
			return new Info().title("product management system")
					.description("RESTFUL API with basic CRUD Operation")
					.version("v1").contact(contact());
		}
	@Bean

	OpenAPI openAPI() {
		return new OpenAPI().info(info());
	}
	}

