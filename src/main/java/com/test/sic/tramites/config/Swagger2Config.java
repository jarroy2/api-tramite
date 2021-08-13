/**
 * 
 */
package com.test.sic.tramites.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Jonathan Arroyo
 *
 */

@Configuration
@EnableSwagger2
public class Swagger2Config {

	
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiEndPointsInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.test.sic.tramites.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiEndPointsInfo() {

		Contact contact = new Contact("Jonathan Arroyo Reina", "#", "ing.jonathan_arroyo@hotmail.com");
		return new ApiInfoBuilder()
				.title("API RESTful Gestión de Servicios Tramites de la SIC ")
				.description(
						"Esta api describe la funcionalidad para los servicios tipo Rest Full para gestionar los tramites de la SIC")
				.version("1.0.0").license("Apache 2.0").licenseUrl("http://www.apache.org/licenses/LICENSE-2.0")
				.contact(contact).build();


	}

}
