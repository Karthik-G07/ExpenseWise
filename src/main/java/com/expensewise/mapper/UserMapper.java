package com.expensewise.mapper;

import com.expensewise.Requestdto.UserRequest;
import com.expensewise.constants.Role;
import com.expensewise.entity.User;
import com.expensewise.responsedto.UserResponse;

public class UserMapper {
 
	public  static User toEntity(UserRequest req)
	{
		User user=new User();
		user.setName(req.getName());
		user.setEmail(req.getEmail());
		user.setPassword(req.getPassword());
		user.setRole(Role.USER);
		return user;
	}
	
	public static UserResponse toResponse(User user)
	{
		UserResponse res=new UserResponse();
		res.setName(user.getName());
		res.setEmail(user.getEmail());
		res.setId(user.getId());
		res.setRole(user.getRole());
		res.setCreatedAt(user.getCreatedAt());
		
		return res;
	}
	
}
