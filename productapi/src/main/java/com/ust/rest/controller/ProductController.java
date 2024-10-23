package com.ust.rest.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.model.Product;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController//Controller + ResponseBody//Spring MVC -Response-we return a ViewResolver-write to body of html
@RequestMapping("/product/api1.0")//root for the resource/controller
public class ProductController {
	ArrayList<Product> productsList= new ArrayList<>();
	{
		productsList.add(new Product(101,"Nike","Black",10,15000));
		productsList.add(new Product(102,"Adidas","white",20,10000));
		productsList.add(new Product(103,"Puma","Grey",12,30000));
	}
	
	
	@GetMapping(value="/productsinfo",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<Product>> productsList() {
		return ResponseEntity.ok(productsList);
	}
	@GetMapping(value="/product/{id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getById(@PathVariable long id){
		Optional<Product> optional=productsList.stream().filter(product->product.getProductid()==id).findFirst();
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	}
	
	@GetMapping(value="/products/{brand}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getBybrand(@PathVariable String brand){
		Optional<Product> optional=productsList.stream().filter(product->product.getBrand().equals(brand)).findFirst();
		return ResponseEntity.status(HttpStatus.OK).body(optional.get());
	}
	@GetMapping("/status")
	public String getMethodName(@RequestParam String param) {
		return "HIii soldiers";
	}
	//postmapping
	
	@PostMapping(value="/addproduct",
			consumes=MediaType.APPLICATION_JSON_VALUE,
			produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> addproduct(@RequestBody Product product){
		boolean flag=false;
			if(product!=null)
				flag=productsList.add(product);
		return flag?ResponseEntity.status(201).body(product):ResponseEntity.status(404).body(null);
		
	}
	@PutMapping(value="modify", consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		Optional<Product> optional= productsList.stream().filter(p->p.getProductid()==product.getProductid()).findFirst();
		
		Product temp=optional.get();
		temp.setBrand(product.getBrand());
		temp.setDescription(product.getDescription());
		temp.setPrice(product.getPrice());
		temp.setProductid(product.getProductid());
		temp.setQty(product.getQty());
		
		
		return ResponseEntity.accepted().body(null);
	}
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable long id) {
		Optional<Product> optional= productsList.stream().filter(p->p.getProductid()==id).findFirst();
		productsList.remove(optional.get());
	}
	
}
