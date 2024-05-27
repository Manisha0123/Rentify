package com.jsp.rentify.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jsp.rentify.dto.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
	@Query("select a from User a where a.email=?1")
	public User fetchByEmail(String email);

}
