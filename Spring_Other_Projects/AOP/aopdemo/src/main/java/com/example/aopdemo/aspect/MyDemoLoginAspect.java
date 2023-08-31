package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

    //This is where we add all of our related advice for logging
    @Before("execution(* com.example.aopdemo.dao(..))")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ------>  Executing @Before advice on method");
    }
}
