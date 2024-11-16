package com.SampleRestApplication.Demo;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@Order(1)
public class SwaggerConfig {

		    @Bean
		    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		    	  http
		            .authorizeRequests().requestMatchers("/swagger-ui/**").permitAll()
		            .anyRequest().authenticated() // Permit all requests to Swagger UI
		            .and()
		            .csrf().disable(); // Disable CSRF protection for Swagger UI
		        return http.build();
		    }
		}
	
	


