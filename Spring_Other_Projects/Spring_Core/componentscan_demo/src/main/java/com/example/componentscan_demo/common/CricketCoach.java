package com.example.componentscan_demo.common;

import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Get daily Workout for fast bowling!!!!!!!";
    }
}
