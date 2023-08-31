package com.ignek.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ignek.ecommerce.model.Customer;
import com.ignek.ecommerce.model.Order;
import com.ignek.ecommerce.repo.OrderRepo;

@Service
public class OrderService {

	@Autowired
	OrderRepo orderRepo;
	
	//Adding Order
		public void addOrder(Order order) {
			orderRepo.save(order);
		}
		
		//GetAll Orders
		public List<Order> getOrders(){
			List<Order> order = new ArrayList<Order>();
			orderRepo.findAll().forEach(orders -> order.add(orders));
			return order;
		}
		
		//Get Order findById
		public Order getOrderById(int orderId) {
			return orderRepo.findById(orderId).get();
		}
		
		
		//Update Order
		public void updateOrder(Order order) {
			orderRepo.save(order);
		}
		
		//Delete Order
		public void deleteOrder(int orderId) {
			Order c = orderRepo.getReferenceById(orderId);
			orderRepo.delete(c);
		}
}
