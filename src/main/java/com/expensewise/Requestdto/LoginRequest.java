package com.expensewise.Requestdto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequest {

	@NotBlank(message = "email is required")
	@NotBlank(message = "invalid email")
	private String email;
	
	
	@NotBlank(message = "pasword is required")
	private String pasword;
	
}
