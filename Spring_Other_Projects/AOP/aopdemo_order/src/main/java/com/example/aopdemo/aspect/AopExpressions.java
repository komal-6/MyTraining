package com.example.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class AopExpressions {

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
    public void forDaoPackageNoGetterSetter(){

    }
}
