package com.expensewise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensewise.Requestdto.LoginRequest;
import com.expensewise.exception.ApiResponse;
import com.expensewise.exception.AppException;
import com.expensewise.responsedto.LoginResponse;
import com.expensewise.service.impl.AuthSerivceImpl;


//@RestController
//@RequestMapping("/api/test")
public class TestController {

	@Autowired
	private AuthSerivceImpl srv;
	
	@GetMapping
	public ResponseEntity<?> test()
	{
		return ResponseEntity.ok("login successfull");
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Validated @RequestBody LoginRequest req,BindingResult result)
	{
		if(result.hasErrors())
		{
			throw new AppException(result.getFieldError().getDefaultMessage(), HttpStatus.BAD_REQUEST);
		}
		
	  LoginResponse logins=	srv.login(req);
		 
	  return ResponseEntity.ok(new ApiResponse<>(" successfull ",logins,HttpStatus.OK));
	
	}
	
	
	
	
}
