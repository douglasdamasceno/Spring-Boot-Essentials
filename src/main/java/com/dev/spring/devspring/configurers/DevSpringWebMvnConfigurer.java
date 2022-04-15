package com.dev.spring.devspring.configurers;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DevSpringWebMvnConfigurer implements WebMvcConfigurer {
	
	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
		PageableHandlerMethodArgumentResolver pageableHander = new PageableHandlerMethodArgumentResolver();
		pageableHander.setFallbackPageable(PageRequest.of(0, 5));
		resolvers.add(pageableHander);
	}
}