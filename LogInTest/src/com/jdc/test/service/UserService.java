package com.jdc.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.jdc.test.errorException;
import com.jdc.test.entity.User;
import com.jdc.test.repository.UserRepo;

public class UserService {
	
	@Autowired
	private UserRepo repo;
	
	public User findbylogin(String name,String pass) {
		
		if(StringUtils.isEmpty(name)) {
			throw new errorException("Please type name");
		}
		if(StringUtils.isEmpty(pass))
			throw new errorException("Please type password ");
		User user=repo.findOneByName(name);
		if (user==null) {
			throw new errorException("Please check name");
		}
		if(!user.getPassword().isEmpty()) {
			throw new errorException("Please check password");
		}
		return user;
			
		
		
	}

}
