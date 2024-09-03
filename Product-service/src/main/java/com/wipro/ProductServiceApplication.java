package com.wipro;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition(
	    info = @Info(
				title="Product Management MicroService API Documentation",
				description="API documentation for product microservice in e-commerce application to manage the CRUD operations on the products",
				version="V1.0",
				contact=@Contact(
						name="Bikkireddy Teja",
						email="bikkireddyteja999@gmail.com",
						url="https://www.teja.com"
						),
				license=@License(
						name="Apache 2.0"
						)
				),
		externalDocs=@ExternalDocumentation(
				description="Spring Boot Product management Documentation",
				url="http:localhost:9093/api/product"
				
				)
		)
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
