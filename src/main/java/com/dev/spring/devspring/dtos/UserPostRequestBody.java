package com.dev.spring.devspring.dtos;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

import lombok.Data;

@Data
public class UserPostRequestBody {
	@NotNull(message = "The username cannot be null")
	@NotEmpty(message = "The username cannot be empty")
    private String username;
	
	@NotNull(message = "The user email cannot be null")
	@NotEmpty(message = "The user email cannot be empty")
	@Email(message = "The email is not valid")
	private String email;
	
	@NotNull(message = "The password cannot be null")
	@NotEmpty(message = "The password cannot be empty")
	 @Size(min = 6, message 
     = "The password must be least 6 characters")
    private String password;
}
