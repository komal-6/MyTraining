package com.ignek.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignek.ecommerce.model.Category;

@Repository("CategoryRepo")
public interface CategoryRepo extends JpaRepository<Category, Integer>{

}
