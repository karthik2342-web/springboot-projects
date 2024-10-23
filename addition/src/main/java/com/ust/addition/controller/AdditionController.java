package com.ust.addition.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/add")
public class AdditionController {
	@GetMapping("/plustwo/{num}")
	public int addnum(@PathVariable("num") int num) {
		return 2+num;
	}

}
