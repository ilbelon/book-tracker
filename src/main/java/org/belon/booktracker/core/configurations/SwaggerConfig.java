package org.belon.booktracker.core.configurations;

import java.util.ArrayList;

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
		return new Docket(DocumentationType.OAS_30)
				.select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build()
				.pathMapping("/")
				.apiInfo(metaData());
	}
	
	private ApiInfo metaData() {
	    return new ApiInfo(
	    		"BOOKS TRACKER API",
	    		"Spring Boot REST API for BOOKS TRACKER",
	    		"Version 0.0.1",
	    		"TERMOFSERVICEURL",
	    		new Contact("Andrea Mazzacani","https://www.andreamazzacani.it","anedraemme@gmail.com"),
	    		"Apache License Version 2.0",
	    		"https://www.apache.org/licenses/LICENSE-2.0.html",
	    		new ArrayList<>());
	}
}
