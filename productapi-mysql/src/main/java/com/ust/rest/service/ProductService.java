package com.ust.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.rest.model.Product;
import com.ust.rest.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;
	public Product addProduct(Product newProduct) {
		return repository.save(newProduct);
	}
	public Optional<Product> displaybyid(long id) {
		return repository.findById(id);
				
	}
	public List<Product> displaybybrand(String brand) {
		return repository.findByBrand(brand);
	}
	public List<Product> displayall(){
		return repository.findAll();
	}
	public Product updateproduct(Product product) {
		if(repository.existsById(product.getId())) {
			return repository.save(product);
		}
		return null;
	}
	public void deleteById(long id) {
		repository.deleteById(id);
		
	}

}
