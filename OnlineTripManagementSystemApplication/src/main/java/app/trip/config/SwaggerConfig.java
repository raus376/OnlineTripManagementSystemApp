package app.trip.config;

import java.util.Collection;
import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo())
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
				
	}

	private ApiInfo getInfo() {
		return new ApiInfo("Trip Management System : REST API",
				"REST API for Online Trip Mangement System created using Spring, Spring Boot, Hibernate, JPA, Maven for Backend Project.",
				"1.0",
				"Terms of Service",
				new Contact("Kunal Ladhani", "https://kunal-ladhani.github.io/", "k.ladhani1@gmail.com"),
				"License of APIs",
				"API License URL",
				Collections.EMPTY_LIST);
	}
}
