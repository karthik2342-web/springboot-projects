package com.ust.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import com.ust.rest.model.Product;

@RestController
@RequestMapping("/client/api1.0")
public class ProductController {
	
	@Autowired
	RestTemplate template;
	
	@GetMapping("/getAllProducts")
	public List<Product> fetchProduct() {
		String url="http://localhost:8090/product/api1.0/productsinfo";
		List<Product> list=template.getForObject(url, List.class);
		return list;
	}
	@GetMapping("/time")
	public String fetchtime() {
		String url="lb://HELLOSERVICE/rest/service/time";
		String time=template.getForObject(url, String.class);
		return time;
	}

}
