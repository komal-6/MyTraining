package com.example.aopdemo.aspect;

import com.example.aopdemo.Account;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
@Order(3)
public class MyDemoLoginAspect {

    @Around("execution(* com.example.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint joinPoint) throws Throwable{

        //Print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n ---> Executing @Around on method " + method);

        long begin = System.currentTimeMillis();
        Object result = null;
        /*try{
            result = joinPoint.proceed();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            result = "Major accident.....";
        }*/

        try{
            result = joinPoint.proceed();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw e;
        }

        long end = System.currentTimeMillis();

        long duration = end - begin;
        System.out.println("\n Duration: "+duration/1000.0 + " seconds");

        return result;
    }

    @After("execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))")
    public void afterFinallyFindAccountAdvice(JoinPoint joinPoint){
       //Print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n ---> Executing @After(finally) on method " + method);
    }



    @AfterThrowing(pointcut = "execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",
                  throwing = "theExc")
    public void afterThrowingFindAccountAdvise(JoinPoint joinPoint,Throwable theExc){

        //Print which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n ---> Executing @AfterReturning on method " + method);


        System.out.println("\n ---> The exception is " + theExc);

    }



    //Add new advice for @AfterReturning on the findAccountsMethod

    @AfterReturning (
            pointcut = "execution(* com.example.aopdemo.dao.AccountDao.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountAdvice(JoinPoint joinPoint, List<Account> result){

        //Print out which method we are advising on
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n ---> Executing @AfterReturning on method " + method);

        //Print out the results of the method call
        System.out.println("\n ---> Result is "+result);

        //Post-process the data ... modify it.
        //Convert account name to uppercase
        convertAccountNamesToUppercase(result);

    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for(Account account: result){
            String upperName = account.getName().toUpperCase();
            account.setName(upperName);
        }
    }

    //This is where we add all of our related advice for logging
    @Before("com.example.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint joinPoint){
        System.out.println("\n ------>  Executing @Before advice on method");


        //Display the method signature
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        System.out.println("Method: "+ methodSignature);


        //Display method argument
        Object[] args = joinPoint.getArgs();
        for (Object arg: args){
            System.out.println(arg);

            if(arg instanceof Account){
                //Downcast and print Account specific stuff
                Account account = (Account) arg;
                System.out.println("Account name: "+account.getName());
                System.out.println("Account level: "+account.getLevel());
            }
        }
    }


}
