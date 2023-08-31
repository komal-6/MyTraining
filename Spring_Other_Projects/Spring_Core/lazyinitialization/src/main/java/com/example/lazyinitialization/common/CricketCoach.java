package com.example.lazyinitialization.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{


    public CricketCoach(){
        System.out.println("In constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Get daily Workout for fast bowling!!!!!!!";
    }
}
