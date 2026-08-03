package com.expensewise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expensewise.Requestdto.UserRequest;
import com.expensewise.responsedto.UserResponse;
import com.expensewise.service.impl.AuthSerivceImpl;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("api/auth")
public class AuthController {
	
	@Autowired
	private AuthSerivceImpl srv;
	
        
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRequest req) {
		
		UserResponse ures=srv.register(req);
		
		return ResponseEntity.ok(ures);
	}
	
}
