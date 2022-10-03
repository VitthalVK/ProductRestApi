package com.example.product.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.product.model.Category;
import com.example.product.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	//method for saving the category
	public Category saveCat(Category cat) {
		return repository.save(cat);
	}
	
	//method for getting the all category details
	public List<Category> getAllCat(){
		return repository.findAll();
	}
	
	//update
	public Category updateCat(Category cat) {
		//find the cat
		Category cat1=repository.findById(cat.getCatId()).orElse(null);
		cat1.setDeliveryCharges(cat.getDeliveryCharges());
		cat1.setDiscount(cat.getDiscount());
		cat1.setGst(cat.getGst());
		cat1.setProductCategory(cat.getProductCategory());
		//save product
		return repository.save(cat);
	}
	
	
    //method for deleting the category
	public void deleteCat(Integer catId) {
		 repository.deleteById(catId);
	}
	
	public Category getCatByName(String catName) {
	 return	repository.getCategoryByProdCate(catName);
	}
}
