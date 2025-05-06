package app.trip.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Configuration
@EnableWebMvc
@OpenAPIDefinition
public class SwaggerConfig {

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.servers(List.of(new Server().url("localhost:8080/")))
				.info(new Info()
						.title("Trip Management System : REST API")
						.description("REST API for Online Trip Management System created using Spring, Spring Boot, Hibernate, JPA, Maven for Backend Project.")
						.version("v1.0.0")
						.contact(new Contact()
								.name("Kunal Ladhani")
								.url("https://kunal-ladhani.github.io/")
								.email("k.ladhani1@gmail.com")
						)
				);
	}
}
