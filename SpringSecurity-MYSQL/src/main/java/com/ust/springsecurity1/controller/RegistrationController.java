package com.ust.springsecurity1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.springsecurity1.model.MyUser;
import com.ust.springsecurity1.repository.UserRepository;

@RestController
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private UserRepository repository;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@PostMapping("/add")
	public MyUser newuser(@RequestBody MyUser user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return repository.save(user);
	}
}
