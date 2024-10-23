package com.ust.factorialapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/factorial")
public class FactorialController {
	@GetMapping("/out/{fact}")
	public int getfactorial(@PathVariable("fact") int fact) {
		int res=1;
		for(int i=2;i<=fact;i++)
			res*=i;
		return res;
	}

}
