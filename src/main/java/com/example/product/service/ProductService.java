package com.example.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
    ProductRepository proRepository;
	
	// CREATE 
	public Product createProduct(Product pro) {
	    return proRepository.save(pro);
	}

	// get all products
	public List<Product> getProducts() {
	    return proRepository.findAll();
	}

	// Delete one product
	public void deleteProduct(Integer productId) {
	    proRepository.deleteById(productId);
	}
	
	//find by id
	public Product findById(Integer pid) {
	  return proRepository.findById(pid).orElse(null);
	}
	
	//update 
	public Product updateProd(Product prod) {
		Product existProduct=proRepository.findById(prod.getPid()).orElse(null);
		//set the new value
		existProduct.setProductCategory(prod.getProductCategory());
		existProduct.setProductName(prod.getProductName());
		existProduct.setProductPrice(prod.getProductPrice());
		existProduct.setProductType(prod.getProductType());
		//save and return
		return proRepository.save(existProduct);
	}
	


}
