package com.expensewise.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.expensewise.Requestdto.LoginRequest;
import com.expensewise.Requestdto.UserRequest;
import com.expensewise.config.SecurityConfig;
import com.expensewise.constants.Role;
import com.expensewise.entity.User;
import com.expensewise.exception.EmailAlreadyExistsException;
import com.expensewise.repository.UserRepository;
import com.expensewise.responsedto.LoginResponse;
import com.expensewise.responsedto.UserResponse;
import com.expensewise.security.JwtService;
import com.expensewise.service.AuthService;

@Service
public class AuthSerivceImpl implements AuthService {

	@Autowired
	private UserRepository urepo;
	
	@Autowired
	private PasswordEncoder pencode;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MailServiceImpl mailser;
	
	@Autowired
	private JwtService jwtserv;
	
	
	
	@Override
	public UserResponse register(UserRequest req) {
		
		urepo.findByEmail(req.getEmail())
		.ifPresent(user->{
			throw new EmailAlreadyExistsException("email is already exits");
		});
		
		
		User user=mapper.map(req, User.class);
		user.setRole(Role.USER);
		user.setPassword(pencode.encode(req.getPassword()));
		
		user=urepo.save(user);
		
//		mailser.sendMail(user.getEmail());
				UserResponse ures=mapper.map(user, UserResponse.class);
		
				
		return ures;
	}


	@Override
	public LoginResponse login(LoginRequest req) {
		
		User user=urepo.findByEmail(req.getEmail()).orElseThrow(()->new RuntimeException("email not found"));
		
		if(!pencode.matches(req.getPassword(), user.getPassword()))
		
		{
			throw new RuntimeException("password miss_match!");
		}
		String token =jwtserv.generateToken(user.getEmail());
		
		return new LoginResponse("login ",token);
	}

}
