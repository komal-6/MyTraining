package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

    @Pointcut("execution(* com.example.aopdemo.dao.*.*(..))")
    public void pointcutMethod(){
    }


     //create pointcut for getter method
     @Pointcut("execution(* com.example.aopdemo.dao.*.get*(..))")
     public void getPointCut(){

     }

    //create pointcut for setter method
    @Pointcut("execution(* com.example.aopdemo.dao.*.set*(..))")
    public void setPointCut(){

    }

    //create pointcut: include package .. exclude getter/setter
    //Combining pointcut declarations
    @Pointcut("pointcutMethod() && !(getPointCut() || setPointCut())")
    private void forDaoPackageNoGetterSetter(){

    }


    //This is where we add all of our related advice for logging
    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(){
        System.out.println("\n ------>  Executing @Before advice on method");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics(){
        System.out.println("\n ------>  Performing Api Analytics");
    }
}
