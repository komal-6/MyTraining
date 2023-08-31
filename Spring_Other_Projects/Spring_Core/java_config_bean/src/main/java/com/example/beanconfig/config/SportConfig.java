package com.example.beanconfig.config;

import com.example.beanconfig.common.Coach;
import com.example.beanconfig.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    @Bean("swim")
    public Coach swimCoach(){
        return new SwimCoach();
    }
}
