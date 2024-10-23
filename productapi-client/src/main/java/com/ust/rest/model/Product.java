package com.ust.rest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private long id;
	private String brand;
	private String description;
	private int qty;
	private int price;
	

}
