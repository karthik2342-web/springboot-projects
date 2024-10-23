package com.ust.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.model.Product;
import com.ust.rest.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController//Controller + ResponseBody//Spring MVC -Response-we return a ViewResolver-write to body of html
@RequestMapping("/product/api1.0")//root for the resource/controller
public class ProductController {
	Logger logger= Logger.getLogger("ProductController.class");
	@Autowired
	
	private ProductService service;
	
	@GetMapping(value="/productsinfo",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> productsList() {
		List<Product> all = service.displayall();
		if(all!=null)
		{
			return ResponseEntity.ok(all);
		}
		else
		{
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping(value="/product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Optional<Product>> getById(@PathVariable long id){
		Optional<Product> optional=service.displaybyid(id);
		return ResponseEntity.status(200).body(optional);
	}
	
	@GetMapping(value="/products/{brand}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> getBybrand(@PathVariable String brand){
		return ResponseEntity.ok(service.displaybybrand(brand));
	}
	
	@PostMapping(value="/addproduct",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addproduct(@RequestBody Product product){
		//logger.info("Entered POST method"+product);
		Product savedproduct=service.addProduct(product);
		//logger.info("Presisted product"+savedproduct);
		return ResponseEntity.status(200).body(savedproduct);
		
	}
	@PutMapping(value="modify", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Product result=service.updateproduct(product);
		if(result!=null) {
			return ResponseEntity.status(200).body(product);
		}
		
		return ResponseEntity.status(204).build();
	}
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable long id) {
		service.deleteById(id);
	}
}