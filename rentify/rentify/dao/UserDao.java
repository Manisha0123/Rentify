package com.jsp.rentify.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.rentify.dto.User;
import com.jsp.rentify.repo.UserRepo;


@Repository
public class UserDao {

	@Autowired
	private UserRepo repo;
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public User fetchByEmail(String email) {
		return repo.fetchByEmail(email);
	}
}
