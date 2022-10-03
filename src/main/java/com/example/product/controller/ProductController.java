package com.example.product.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Category;
import com.example.product.model.DumyProduct;
import com.example.product.model.Product;
import com.example.product.service.CategoryService;
import com.example.product.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	@Autowired
    ProductService proService;
	@Autowired
    CategoryService categoryService;
	
	//save product
	@PostMapping()
	public Product createProduct(Product pro) {
	    return proService.createProduct(pro);
	}
	
	//getting the all products
	@GetMapping()
	public List<Product> readProducts() {
	    return proService.getProducts();
	}
	
	//getting the specific product
	@GetMapping("{pId}")
	public DumyProduct getProdct(@PathVariable Integer pId) {
		Product product= proService.findById(pId);
		DumyProduct dp=new DumyProduct();		
		dp.setPid(product.getPid());
		dp.setProductName(product.getProductName());
		dp.setProductType(product.getProductType());
		dp.setProductCategory(product.getProductCategory());
		dp.setBaserPrice(product.getProductPrice());		
		//getting the category of product
		Category category=categoryService.getCatByName(product.getProductCategory());
		dp.setDiscount((product.getProductPrice()*category.getDiscount())/100);		
		dp.charges.put("gst", ((product.getProductPrice()*category.getGst())/100));
		dp.charges.put("delivery", category.getDeliveryCharges());
		dp.setFinalPrice(product.getProductPrice()+dp.charges.get("gst")+dp.charges.get("delivery"));
		return dp;		
	}
	
	//update product
	@PutMapping("/update")
	public Product updateProd(Product product) {
		return proService.updateProd(product);
	}

}
