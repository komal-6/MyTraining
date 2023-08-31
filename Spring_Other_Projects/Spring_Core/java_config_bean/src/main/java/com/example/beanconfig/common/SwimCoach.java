package com.example.beanconfig.common;

public class SwimCoach implements Coach{

    public SwimCoach(){
        System.out.println("In SwimCoach constructor: "+getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "In SwimCoach Daily Workout method";
    }
}
