package com.ignek.customanno1.customannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnno {
	int myValue() default 0;
	String name() default "Komal";
	String city() default "Ahmedabad";
	
}
