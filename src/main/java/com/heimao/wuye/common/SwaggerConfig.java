package com.heimao.wuye.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration  
@EnableSwagger2
public class SwaggerConfig {
	
	@Bean
	public Docket adminApi(){
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("Admin API")
				.forCodeGeneration(true)
				.pathMapping("/")
				.select()
				.paths(paths())
				.build()
				.apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}
	
	private Predicate<String> paths(){
		return PathSelectors.regex("^/(?!error).*$");
	}
	
	
	private ApiInfo apiInfo(){
		return new ApiInfoBuilder()
				.title("Document Api")
				.description("Spring-boot-Springfox Example")
				.license("Apache License Version 2.0")
				.version("2.0")
				.build();
	}
}
