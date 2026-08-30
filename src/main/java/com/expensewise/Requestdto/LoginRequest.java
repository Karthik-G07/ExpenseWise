package com.expensewise.Requestdto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

	@NotBlank(message = "email is required")
	@Email(message = "please enter a valid email")
	private String email;
	
	
	@NotBlank(message = "password is required")
	@Length(min=6,message="Password must contain at least 6 characters")
	private String password;
	
}
