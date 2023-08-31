package com.ignek.ecommerce.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ignek.ecommerce.model.Order;

@Repository("OrderRepo")
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
