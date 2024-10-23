package com.ust.feignclient.resourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.feignclient.ifaces.ProductFeignIface;
import com.ust.feignclient.model.Product;

@RestController
@RequestMapping("/client")
public class FeignClient {
	@Autowired
	private ProductFeignIface feignclient;
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return feignclient.getAllProducts();		
	}
}
