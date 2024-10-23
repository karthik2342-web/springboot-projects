package com.ust.springsecurity.controller;

import java.util.ArrayList;
import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.springsecurity.model.Product;
import com.ust.springsecurity.service.MyUserDetailsService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController//Controller + ResponseBody//Spring MVC -Response-we return a ViewResolver-write to body of html
@RequestMapping("/product/api1.0")//root for the resource/controller
public class ProductController {
	Logger logger= Logger.getLogger("ProductController.class");
	@Autowired
	private MyUserDetailsService service;
	@GetMapping(value="/productsinfo",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Product>> productsList() {
		return null;
	}
	@GetMapping(value="/product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getById(@PathVariable long id){
		
		return null;
	}
	
	@GetMapping(value="/products/{brand}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getBybrand(@PathVariable String brand){
		return null;
	}
	@GetMapping("/status")
	public String getMethodName(@RequestParam String param) {
		return null;
	}
	//postmapping
	
	@PostMapping(value="/addproduct",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addproduct(@RequestBody Product product){
		logger.info("Entered POST method"+product);
		Product savedproduct=service.addProduct(product);
		logger.info("Presisted product"+savedproduct);
		return ResponseEntity.status(200).body(savedproduct);
		
	}
	@PutMapping(value="modify", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		
		
		return null;
	}
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable long id) {
		
	}
	
}
