package com.example.aopdemo.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class TrafficforyuneServiceImpl implements TrafficFortuneService{
    @Override
    public String getFortune() {

        //Simulate the delay
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //Return a fortune
        return "Except heavy traffic";
    }

    @Override
    public String getFortune(boolean tripWire) {
        if(tripWire){
            throw new RuntimeException("Major accident");
        }
        return getFortune();
    }
}
