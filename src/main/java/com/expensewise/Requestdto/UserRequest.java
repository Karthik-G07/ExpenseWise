package com.expensewise.Requestdto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class UserRequest { 
 
	@NotBlank(message = "name is required")
    private	String name;
		
	@Email(message = "invalid email")
	@NotBlank(message = "email is required")
	private String email;
	
	@Size(min = 8,message = "password length should be atleast 8")
	private String password;
	
	
	
}
