package com.example.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.product.model.Category;


public interface CategoryRepository extends JpaRepository<Category, Integer> {
	   //JPQL command
    @Query("select c from Category c where c.productCategory=?1")
    Category getCategoryByProdCate(String ProdCat) ;
}
