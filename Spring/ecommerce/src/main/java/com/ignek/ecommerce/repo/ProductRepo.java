package com.ignek.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignek.ecommerce.model.Product;

@Repository("ProductRepo")
public interface ProductRepo extends JpaRepository<Product, Integer>{

}
