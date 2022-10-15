package com.gnanayakkara.SpringTest;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class SpringExceptionHandlerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringExceptionHandlerApplication.class, args);
	}
	
	
	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/users/*"))
				.apis(RequestHandlerSelectors.basePackage("com.gnanayakkara.SpringTest"))
				.build()
				.apiInfo(apiDetails());
	}
	
	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Users API", 
				"Sample API for Exception Handler", 
				"1.0", 
				"For education purpose only",
				"com.gnanayakkara.com",
				"Free licence",
				"http://gnanayakkara.io");
	}

}
