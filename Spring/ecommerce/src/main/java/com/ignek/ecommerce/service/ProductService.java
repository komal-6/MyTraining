package com.ignek.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignek.ecommerce.model.Customer;
import com.ignek.ecommerce.model.Product;
import com.ignek.ecommerce.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	ProductRepo productRepo;
	
	//Adding Product
		public void addProduct(Product product) {
			productRepo.save(product);
		}
		
		//GetAll Products
		public List<Product> getProducts(){
			List<Product> product = new ArrayList<Product>();
			productRepo.findAll().forEach(products -> product.add(products));
			return product;
		}
		
		//Get Product findById
		public Product getProductById(int productId) {
			return productRepo.findById(productId).get();
		}
		
		
		//Update Product
		public void updateProduct(Product product) {
			productRepo.save(product);
		}
		
		//Delete Product
		public void deleteProduct(int productId) {
			Product c = productRepo.getReferenceById(productId);
			productRepo.delete(c);
		}
}
