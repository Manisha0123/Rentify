package com.jsp.rentify.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.jsp.rentify.dto.Property;
import com.jsp.rentify.repo.PropertyRepo;

@Repository
public class PropertyDao {
	
	@Autowired
	private PropertyRepo repo;
	
	public Property saveProperty(Property property) {
		return repo.save(property);
	}
	
	public List<Property> getPropertiesByUserId(Long userId) {
        return repo.findByUserId(userId);
    }
	
	public List<Property> findAll(){
		return repo.findAll();
	}
	
	public Property deletePropertyById(Long id) {
		 Optional<Property> db = repo.findById(id);
		if(db.isPresent()) {
			repo.deleteById(id);
			return db.get();
		}
		else {
			return null;
		}
	}
	
	public Property updateProperty(Property property) {
		 Optional<Property> db = repo.findById(property.getId());
		if(db.isPresent()) {
			return repo.save(property);
		}else {
			return null;
		}
	}
}
