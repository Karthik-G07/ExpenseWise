package com.expensewise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.expensewise.Requestdto.UserRequest;
import com.expensewise.entity.User;
import com.expensewise.mapper.UserMapper;
import com.expensewise.repository.UserRepository;
import com.expensewise.responsedto.UserResponse;
import com.expensewise.service.AuthService;

@Service
public class AuthSerivceImpl implements AuthService {

	@Autowired
	private UserRepository urepo;
	
	
	@Override
	public UserResponse register(UserRequest req) {
		
		User user=UserMapper.toEntity(req);
		
		user=urepo.save(user);
		
		
		
		return UserMapper.toResponse(user);
	}

}
