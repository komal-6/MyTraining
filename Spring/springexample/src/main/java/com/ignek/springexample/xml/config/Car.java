package com.ignek.springexample.xml.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car implements Vehicle{
	
	@Autowired
	private Tire tire;
	
	
	public Tire getTire() {
		return tire;
	}


	public void setTire(Tire tire) {
		this.tire = tire;
	}


	public void drive() {
		System.out.println("Car is working " + tire);
	}
}
