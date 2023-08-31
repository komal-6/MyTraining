package com.ignek.SpringAnno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
       Samsung samsung = factory.getBean(Samsung.class);
       samsung.config();
    }
}
