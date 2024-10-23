package com.ust.feignclient.ifaces;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.ust.feignclient.model.Product;

@FeignClient(value="feignclient" , url ="http://localhost:8090/product/api1.0")
public interface ProductFeignIface {
	
	@GetMapping("/productsinfo")
	public List<Product> getAllProducts();
}
