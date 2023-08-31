package com.ignek.springexample.xml.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		/*
		 * Vehicle obj = (Vehicle)context.getBean("bike"); obj.drive();
		 */
    	
    	Car obj = (Car)context.getBean("car");
    	obj.drive();
		/*
		 * Tire tire =(Tire)context.getBean("tire"); System.out.println(tire);
		 */
    }
}
