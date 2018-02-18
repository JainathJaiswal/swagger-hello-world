package com.jai;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket postsApi() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);

		docket.groupName("public-api").apiInfo(apiInfo()).select().paths(postPaths()).build();

		docket.globalResponseMessage(RequestMethod.GET,
				ImmutableList.of(
						new ResponseMessageBuilder().code(400).message("Bad Request")
								.responseModel(new ModelRef("Error")).build(),
						new ResponseMessageBuilder().code(500).message("Internal Server Error")
								.responseModel(new ModelRef("Error")).build()));

		return docket;
	}

	private Predicate<String> postPaths() {
		return or(regex("/api/posts.*"), regex("/swagger.*"));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger Example")
				.description(
						"Swagger is an open source software framework that helps developers design, build, document, and consume RESTful Web services. Basically it's provide the description/documentation of your Restful Web Service.")
				.termsOfServiceUrl("http://localhost:8080/swagger-ui.html").licenseUrl("a@b.com")
				.version("1.0").build();
	}

}
