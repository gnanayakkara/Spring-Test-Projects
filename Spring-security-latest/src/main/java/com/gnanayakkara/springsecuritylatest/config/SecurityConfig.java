package com.gnanayakkara.springsecuritylatest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/*
 * 26 Mar 2023
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder encoder) {
		
		UserDetails admin = User.withUsername("admin") 
				.password(encoder.encode("123"))
				.roles("ADMIN")
				.build();
	
		UserDetails user = User.withUsername("user")
				.password(encoder.encode("123"))
				.roles("USER")
				.build();
		
		return new InMemoryUserDetailsManager(admin,user);
	}
	
	@Bean
	public SecurityFilterChain sercurityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/products/welcome")
				.permitAll()
				.and()
				.authorizeHttpRequests()
				.requestMatchers("/products/**")
				.authenticated()
				.and()
				.formLogin()
				.and()
				.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
