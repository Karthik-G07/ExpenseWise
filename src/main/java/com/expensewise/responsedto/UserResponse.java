package com.expensewise.responsedto;

import java.time.LocalDateTime;

import com.expensewise.constants.Role;

import lombok.Data;

@Data
public class UserResponse {

	private Long id;
	
	private String name;
	
	private String email;
	 
	private Role role;
	
	private LocalDateTime createdAt;
	
}
