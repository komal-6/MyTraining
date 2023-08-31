package com.example.beanscope.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{


    public CricketCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }

    //Define our init method
    @PostConstruct
    public void doMyStartup(){
        System.out.println("In doMyStartup(): "+getClass().getSimpleName());
    }

    //Define our destory method
    @PreDestroy
    public void doMyCleanup(){
        System.out.println("In doMyCleanup(): "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Get daily Workout for fast bowling!!!!!!!";
    }
}
