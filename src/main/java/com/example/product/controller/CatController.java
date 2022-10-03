package com.example.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.product.model.Category;
import com.example.product.service.CategoryService;

@RestController
@RequestMapping("/cat")
public class CatController {

	@Autowired
	CategoryService catService;
	@GetMapping()
	public List<Category> getAllCat(){
		return catService.getAllCat();
	}
	
	@PostMapping()
	public Category saveCat(Category cat) {
		return catService.saveCat(cat);
	}
	
	@PutMapping("/updateCat")
	public Category updateCat(Category cat) {
		return catService.updateCat(cat);
	}
	
	@DeleteMapping("/deleteCat/{catId}")
	public String deleteCat(@PathVariable Integer catId ) {
		catService.deleteCat(catId);
		return "category Deleted Successfylly";
	}
	
	
}
