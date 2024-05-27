package com.jsp.rentify.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Property {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private String location;
    private Double area;
    private Integer bedrooms;
    private Integer bathrooms;
    private String nearbyHospitals;
    private String nearbyColleges;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
