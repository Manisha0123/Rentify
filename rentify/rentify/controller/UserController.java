package com.jsp.rentify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.jsp.rentify.dto.User;
import com.jsp.rentify.service.UserService;
import com.jsp.rentify.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "*",methods = {RequestMethod.POST,RequestMethod.PUT,RequestMethod.GET,RequestMethod.DELETE})
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<User>> saveUser(@RequestBody User user){
		return service.saveUser(user);	
	}
	
	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<User>> loginUser(@RequestParam String username, String pwd) {
		return service.loginUser(username, pwd);
	}
	
	@GetMapping("/fetchByemail")
	public ResponseEntity<ResponseStructure<User>> fetchById(@RequestParam String email){
		return service.findByEmail(email);
	}
}
