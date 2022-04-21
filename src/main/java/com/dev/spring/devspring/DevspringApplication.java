package com.dev.spring.devspring;

import org.springframework.boot.SpringApplication;
// import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
// import org.springframework.context.annotation.ComponentScan;

// @EnableAutoConfiguration
// @ComponentScan
// (basePackages = "com.dev.spring.devspring")
@SpringBootApplication
public class DevspringApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(DevspringApplication.class, args);
	}
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		registry.addMapping("/animes/**")
			.allowedMethods("POST","GET","PUT","DELETE")
			.allowedOrigins("http://localhost:3000");
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
}
