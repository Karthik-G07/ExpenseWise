package com.expensewise.service;

import com.expensewise.Requestdto.UserRequest;
import com.expensewise.responsedto.UserResponse;

public interface AuthService {

	public UserResponse register(UserRequest req);
	
	
	
}
