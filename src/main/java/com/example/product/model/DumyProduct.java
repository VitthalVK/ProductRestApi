package com.example.product.model;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DumyProduct {

	private Integer pid;
	private String productName;   
	private String productType;	
	private String productCategory;
	private Integer baserPrice;
	private Integer discount;
   public HashMap<String, Integer> charges=new HashMap<>();
	private Integer finalPrice;
	
}
