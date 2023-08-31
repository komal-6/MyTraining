package com.example.aopcruddemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class DemoLoggingAspect {

    //Setup Logger
    private Logger logger = Logger.getLogger(getClass().getName());

    @Pointcut("execution(* com.example.aopcruddemo.controller.*.*(..))")
    public void forControllerPackage(){

    }

    @Pointcut("execution(* com.example.aopcruddemo.service.*.*(..))")
    public void forServicePackage(){

    }
    @Pointcut("execution(* com.example.aopcruddemo.dao.*.*(..))")
    public void forDaoPackage(){

    }

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    public void appFlow(){

    }

    @Before("appFlow()")
    public void before(JoinPoint joinPoint){

        //Display method we are calling
        String method = joinPoint.getSignature().toShortString();
        logger.info("In @Before: Calling  method "+ method);

        //Diaplay the arguments
        Object[] args = joinPoint.getArgs();

        for (Object arg: args){
            logger.info("Argument "+ arg);
        }
    }
    //@AfterReturning advice
    @AfterReturning(pointcut = "appFlow()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result){
        //display method we are returning from
        String method = joinPoint.getSignature().toShortString();
        logger.info("In @AfterReturning: Calling  method "+ method);

        //Display data returned
        logger.info("Result: "+result);
    }
}
