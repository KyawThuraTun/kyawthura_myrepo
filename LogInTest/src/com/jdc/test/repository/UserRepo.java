package com.jdc.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.test.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	
	User findOneByName(String name);

}
