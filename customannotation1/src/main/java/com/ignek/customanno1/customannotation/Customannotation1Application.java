package com.ignek.customanno1.customannotation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Customannotation1Application {

	public static void main(String[] args) {
		SpringApplication.run(Customannotation1Application.class, args);
		
		Demo d = new Demo();
		Class c = d.getClass();
	    System.out.println(c.getName());
	    MyAnno an = (MyAnno) c.getAnnotation(MyAnno.class);
	    System.out.println(an.myValue());
	    System.out.println(an.name());
	    System.out.println(an.city());
	}

}
