package com.jsp.rentify.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.jsp.rentify.dto.Property;

public interface PropertyRepo extends JpaRepository<Property, Long>{
	
	@Query("select a from Property a where a.user.id=?1")
	public List<Property> findByUserId(Long UserId);
	
	@Query("select a from Property a")
	public List<Property> findAll();
}
