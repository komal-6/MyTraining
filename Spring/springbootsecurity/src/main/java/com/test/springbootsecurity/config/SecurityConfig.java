package com.test.springbootsecurity.config;
	

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.test.springbootsecurity.model.User;


@Configuration
@EnableWebSecurity
public class SecurityConfig{
	

	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http.csrf().disable()
		.authorizeHttpRequests()
		.requestMatchers("/home").permitAll()
		.requestMatchers("/users/getUsers")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		return http.build();
	}
	
	

}
