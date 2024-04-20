package com.OCCB.OCCB.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.OCCB.OCCB.model.ResponseLogin;
import com.OCCB.OCCB.model.User;
import com.OCCB.OCCB.model.tokenGen;
import com.OCCB.OCCB.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	
	@GetMapping("/api/users")
	public List<User> listUsers(){
		return userRepository.findAll();
	}
	
	@PostMapping("api/user")
	public String createUser(@RequestBody User user) {
		userRepository.save(user);
		return "User created.";
	}
	
	@PostMapping("/auth/login")
	public ResponseEntity<ResponseLogin> login(@RequestBody User user) {
		ResponseLogin 	response = null;
		User foundUser = userRepository.findByUsername(user.getUsername());
		System.out.println("foundUser: " + foundUser.getUsername());
		if(foundUser.getPassword().equals(user.getPassword())){
			response = new ResponseLogin();
			response.user = foundUser;
			response.token = tokenGen.generateToken();
			return new ResponseEntity<ResponseLogin>(response, HttpStatus.OK);
		}else {
			return new ResponseEntity<ResponseLogin>(response, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/james")
	public ResponseEntity<Boolean> james(@RequestParam(name = "token") UUID token) {
		System.out.println("token: " + token);
		if (tokenGen.loggout(token)) {
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}else {
			return new ResponseEntity<Boolean>(false, HttpStatus.BAD_REQUEST);
		}
	}
	@PostMapping("/auth/verifytoken")
	public ResponseEntity<Object> verifyToken(@RequestHeader("Authorization") String token) {
		token =  token.replace("Bearer ","");
		System.out.println("token: " + token);
		UUID tokenUUID = UUID.fromString(token);
		if (tokenGen.verifyToken(tokenUUID)) {
			return new ResponseEntity<Object>(tokenUUID, HttpStatus.OK);
		}else {
			return new ResponseEntity<Object>(null, HttpStatus.BAD_REQUEST);
		}
	}
}


