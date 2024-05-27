package com.jsp.rentify.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.jsp.rentify.dao.UserDao;
import com.jsp.rentify.dto.User;
import com.jsp.rentify.util.ResponseStructure;
import com.jsp.rentify.exception.EmailWrongException;
import com.jsp.rentify.exception.PasswordWrongException;


@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	@Autowired
	private JavaMailSender emailSender;
	
	ResponseStructure<User> structure = new ResponseStructure<User>();
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		structure.setData(dao.saveUser(user));
		structure.setMessage("user saved successfully...");
		structure.setStatus(HttpStatus.OK.value());
		
		SimpleMailMessage message = new SimpleMailMessage(); 
        message.setFrom("saimanisha122000@gmail.com");
        message.setTo(user.getEmail()); 
        message.setSubject("Registration"); 
        message.setText("Your email is successfully registered for swastha");
        emailSender.send(message);
		return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<User>> loginUser(String username,String pwd){
		User db = dao.fetchByEmail(username);
		if(db!=null) {
			if(db.getPwd().equals(pwd)) {
				structure.setData(db);
				structure.setMessage("user login successful");
				structure.setStatus(HttpStatus.OK.value());
				return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.OK);
			}
			throw new PasswordWrongException();
		}
		throw new EmailWrongException();
	}
	
	public ResponseEntity<ResponseStructure<User>> findByEmail(String email){
		User db = dao.fetchByEmail(email);
		if(db!=null) {
			structure.setData(db);
			structure.setMessage("fetched successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			
			return new ResponseEntity<ResponseStructure<User>>(structure, HttpStatus.FOUND);
		}
		throw new EmailWrongException();
	}
	

}
