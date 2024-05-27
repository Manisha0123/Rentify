package com.jsp.rentify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.rentify.dao.PropertyDao;
import com.jsp.rentify.dto.Property;
import com.jsp.rentify.service.PropertyService;
import com.jsp.rentify.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class PropertyController {

	@Autowired
	private PropertyService service;
	
	@PostMapping("/saveProperty")
	public Property saveSpecialist(@RequestBody Property property){
		return service.saveProperty(property);
	}
	
	@GetMapping("/findById")
    public List<Property> getUserProperties(@RequestParam Long id) {
        return service.getPropertiesByUserId(id);
    }
	
	@GetMapping("/findByAll")
    public List<Property> findAll() {
        return service.findAll();
    }
	
	@DeleteMapping("/delete")
	public Property deletePropertyById(@RequestParam Long id) {
		return service.deletePropertyById(id);
	}
	
	@PutMapping("/update")
	public Property updateProperty(@RequestBody Property property) {
		return service.updateProperty(property);
	}
}
