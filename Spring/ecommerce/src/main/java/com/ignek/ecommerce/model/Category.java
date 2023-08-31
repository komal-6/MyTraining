package com.ignek.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Category {
	@Id
	@Column(name="categoryId")
	private int categoryId;
	private String name;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "product_Id")
	private Product product;
	
	public Category() {
		super();
	}
	
	
	public Category(int categoryId, String name, Product product) {
		super();
		this.categoryId = categoryId;
		this.name = name;
		this.product = product;
	}


	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", name=" + name + ", product=" + product + "]";
	}
}
