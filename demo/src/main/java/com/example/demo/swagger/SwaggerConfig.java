
package com.example.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket userApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo.controller")).build().apiInfo(apiInfo());
	}

	ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("demo REST CRUD operations API in Spring-Boot ")
				.description(
						"Sample REST API for centalized documentation using Spring Boot and spring-fox swagger 2 ")
				.termsOfServiceUrl("").version("0.0.1-SNAPSHOT").contact(new Contact("Vasavi","","")).build();
	}
}
