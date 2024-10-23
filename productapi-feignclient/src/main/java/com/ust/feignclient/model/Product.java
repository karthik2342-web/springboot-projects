package com.ust.feignclient.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Product {
	
	private long id;
	private String brand;
	private String description;
	private int qty;
	private int price;
	

}