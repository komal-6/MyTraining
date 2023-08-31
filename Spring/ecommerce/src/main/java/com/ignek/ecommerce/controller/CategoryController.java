package com.ignek.ecommerce.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ignek.ecommerce.model.Category;
import com.ignek.ecommerce.repo.CategoryRepo;
import com.ignek.ecommerce.service.CategoryService;

@RestController
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@PostMapping("/addCategory")
	public int addCategory(Category category) {
		categoryService.addCategory(category);
		return category.getCategoryId();
	}
	
	@GetMapping("/getCategories")
	public List<Category> getCategories(){
		return categoryService.getCategories();
	}
	
	@GetMapping("/getCategory/{categoryId}")
	public Category getCategory(@PathVariable("categoryId") int categoryId) {	
		return categoryService.getCategoryById(categoryId);
	}
	
	@PutMapping("/updateCategory")
	public Category savOrUpdate(@RequestBody Category category) {
		categoryService.updateCategory(category);
		return category;
	}
	
	@DeleteMapping("/deleteCategory/{categoryId}")
	public String deleteCategory(@PathVariable("categoryId") int categoryId) {
		categoryService.deleteCategory(categoryId);
		return "deleted";
	}
	
}
