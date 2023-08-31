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

import com.ignek.ecommerce.model.Product;
import com.ignek.ecommerce.repo.ProductRepo;
import com.ignek.ecommerce.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@PostMapping("/addProduct")
	public int addProduct(Product product) {
		productService.addProduct(product);
		return product.getProductId();
	}
	
	@GetMapping("/getProducts")
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/getProduct/{productId}")
	public Product getProduct(@PathVariable("productId") int productId) {
		return productService.getProductById(productId);
	}
	
	@PutMapping("/updateProduct")
	public Product saveOrUpdate(@RequestBody Product product) {
		productService.updateProduct(product);
		return product;
	}
	
	@DeleteMapping("/deleteProduct/{productId}")
	public String deleteProduct(@PathVariable("productId") int productId) {
		productService.deleteProduct(productId);
		return "deleted";
	}
}
