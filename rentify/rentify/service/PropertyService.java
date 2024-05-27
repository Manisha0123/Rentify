package com.jsp.rentify.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jsp.rentify.dao.PropertyDao;
import com.jsp.rentify.dto.Property;

@Service
public class PropertyService {
	
	@Autowired
	private PropertyDao dao;
	
	public Property saveProperty(Property property) {
		return dao.saveProperty(property);
	}
	
	public List<Property> getPropertiesByUserId(Long userId) {
        return dao.getPropertiesByUserId(userId);
    }
	
	public List<Property> findAll(){
		return dao.findAll();
	}
	
	public Property deletePropertyById(Long id) {
		return dao.deletePropertyById(id);
	}
	
	public Property updateProperty(Property property) {
		return dao.updateProperty(property);
	}
}
