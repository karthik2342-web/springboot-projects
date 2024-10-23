package com.ust.cloudgateway.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController

public class FallBackController {
	@RequestMapping("/myfallback")
		public ResponseEntity<String> fallBackMethod(){
			return 
					ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("please try after some time");
		}
}
