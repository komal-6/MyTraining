package com.ignek.customanno.customannotation;

import java.lang.annotation.Annotation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomannotationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomannotationApplication.class, args);
		
		
		NokiaSeries ns = new NokiaSeries("Fire", 5);
		Class c = ns.getClass();
		Annotation an = c.getAnnotation(SmartPhone.class);
		SmartPhone s = (SmartPhone) an;
		System.out.println(s.os());
		System.out.println(s.version());
	}
}
