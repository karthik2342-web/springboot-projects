package com.ust.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpringSecurityController {
	@GetMapping("/")
	public String greet() {
		return "Hii soldiers";
	}
	@GetMapping("/admin")
	public String greetadmin() {
		return "Admin @ work";
	}
	@GetMapping("/user")
	public String greetuser() {
		return "user @ work";
	}
}
