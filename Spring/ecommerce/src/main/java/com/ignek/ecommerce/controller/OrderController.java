package com.ignek.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ignek.ecommerce.model.Order;
import com.ignek.ecommerce.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;
	
	@PostMapping("/addOrder")
	public int addOrder(Order order) {
		orderService.addOrder(order);
		return order.getOrderId();
	}
	
	@GetMapping("/getOrders")
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	
	@GetMapping("/getOrder/{orderId}")
	public Order getOrderById(@PathVariable("orderId") int orderId){
		return orderService.getOrderById(orderId);
	}
	
	@PutMapping("/updateOrder")
	public Order saveOrUpdate(@RequestBody Order order) {
		orderService.updateOrder(order);
		return order;
	}
	
	@DeleteMapping("/deleteOrder/{orderId}")
	public String deleteOrder(@PathVariable("orderId") int orderId) {
		orderService.deleteOrder(orderId);
		return "deleted";
	}
}
