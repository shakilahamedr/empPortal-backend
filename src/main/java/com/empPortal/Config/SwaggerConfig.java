package com.empPortal.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

// URL to access swagger-ui =   http://localhost:9095/swagger-ui/
// URL to view API docs = http://localhost:9095/v2/api-docs

@Configuration
public class SwaggerConfig {

	 @Bean
	    public Docket api() { 
	        return new Docket(DocumentationType.SWAGGER_2)  
	          .select()                                  
	          .apis(RequestHandlerSelectors.any())              
	          .paths(PathSelectors.any())                          
	          .build();                                           
	    }
	 
//	@Bean
//	public Docket configureSwagger() {
//		return new Docket(DocumentationType.SWAGGER_2).select()
//				.paths(PathSelectors.ant("/**"))
//				.apis(RequestHandlerSelectors.basePackage("com.shakil.jwtold"))
//				.build();
//	}
	
//	@Bean
//	public Docket api() {
//
//		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
//				.paths(PathSelectors.any()).build();
//
//	}
}
