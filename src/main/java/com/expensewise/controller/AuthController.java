package com.expensewise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensewise.Requestdto.LoginRequest;
import com.expensewise.Requestdto.UserRequest;
import com.expensewise.exception.ApiResponse;
import com.expensewise.exception.AppException;
import com.expensewise.responsedto.LoginResponse;
import com.expensewise.responsedto.UserResponse;
import com.expensewise.service.impl.AuthSerivceImpl;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	@Autowired
	private AuthSerivceImpl srv;
	
        
	@PostMapping("/register")
	public ResponseEntity<?> register(@Validated @RequestBody UserRequest req,BindingResult result) {
		

		if(result.hasErrors())
		{
			throw new AppException(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
		UserResponse ures=srv.register(req);
		
		return ResponseEntity.ok(new ApiResponse<>("registeration succssfull ",ures,HttpStatus.OK));
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Validated @RequestBody LoginRequest req,BindingResult result)
	{
		if(result.hasErrors())
		{
			throw new AppException(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
	  LoginResponse logins=	srv.login(req);
		 
	  return ResponseEntity.ok(new ApiResponse<>("registeration successfull ",logins,HttpStatus.OK));
	
	}
	
}
