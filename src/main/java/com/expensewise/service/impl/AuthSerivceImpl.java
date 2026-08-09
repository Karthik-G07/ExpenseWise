package com.expensewise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensewise.Requestdto.LoginRequest;
import com.expensewise.Requestdto.UserRequest;
import com.expensewise.config.SecurityConfig;
import com.expensewise.entity.User;
import com.expensewise.exception.EmailAlreadyExistsException;
import com.expensewise.mapper.UserMapper;
import com.expensewise.repository.UserRepository;
import com.expensewise.responsedto.LoginResponse;
import com.expensewise.responsedto.UserResponse;
import com.expensewise.service.AuthService;

@Service
public class AuthSerivceImpl implements AuthService {

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private PasswordEncoder pencode;
	
	
	@Override
	public UserResponse register(UserRequest req) {
		
		urepo.findByEmail(req.getEmail())
		.ifPresent(user->{
			throw new EmailAlreadyExistsException("email is already exits");
		});
		
		
		User user=UserMapper.toEntity(req);
		
		user.setPassword(pencode.encode(req.getPassword()));
		
		user=urepo.save(user);
		
		
		
		return UserMapper.toResponse(user);
	}


	@Override
	public LoginResponse login(LoginRequest req) {
		
		User user=urepo.findByEmail(req.getEmail()).orElseThrow(()->new RuntimeException("email not found"));
		
		if(!pencode.matches(req.getPasword(), user.getPassword()))
		{
			throw new RuntimeException("password mismatch");
		}
		
		return new LoginResponse("login sucess");
	}

}
