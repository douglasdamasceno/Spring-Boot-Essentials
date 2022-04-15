package com.dev.spring.devspring.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AnimePutRequestBody {
	
	
    private Long id;
	@NotNull(message = "The anime name cannot be empty")
	@NotEmpty(message = "The anime name cannot be null")
    private String name;
}
