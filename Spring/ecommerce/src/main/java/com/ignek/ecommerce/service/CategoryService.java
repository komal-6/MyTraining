package com.ignek.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ignek.ecommerce.model.Category;
import com.ignek.ecommerce.repo.CategoryRepo;

@Service
public class CategoryService {

	@Autowired
	CategoryRepo categoryRepo;
	
		//Adding Category
		public void addCategory(Category category) {
			categoryRepo.save(category);
		}
		
		//GetAll Categories
		public List<Category> getCategories(){
			List<Category> category = new ArrayList<Category>();
			categoryRepo.findAll().forEach(categories -> category.add(categories));
			return category;
		}
		
		//Get Category findById
		public Category getCategoryById(int categoryId) {
			return categoryRepo.findById(categoryId).get();
		}
		
		
		//Update Category
		public void updateCategory(Category category) {
			categoryRepo.save(category);
		}
		
		//Delete Category
		public void deleteCategory(int categoryId) {
			Category c = categoryRepo.getReferenceById(categoryId);
			categoryRepo.delete(c);
		}
}
