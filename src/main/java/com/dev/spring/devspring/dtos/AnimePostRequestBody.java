package com.dev.spring.devspring.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class AnimePostRequestBody {
	@NotNull(message = "The anime name cannot be null")
	@NotEmpty(message = "The anime name cannot be empty")
    private String name;
}
