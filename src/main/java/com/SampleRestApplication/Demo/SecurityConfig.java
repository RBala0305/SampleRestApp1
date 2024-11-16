package com.SampleRestApplication.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


	@Configuration
	@EnableWebSecurity
	public class SecurityConfig{
		
//		  private final UserDetailsService userDetailsService;
//
//		    @Autowired
//		    public SecurityConfig(UserDetailsService userDetailsService) {
//		        this.userDetailsService = userDetailsService;
//		    }
//
//		    @Bean
//		    public PasswordEncoder passwordEncoder() {
//		        return new BCryptPasswordEncoder();
//		    }
//
//		    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//		    }
            @Bean
		    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {
		        http
//		            .csrf().disable()
//		            .authorizeRequests()
//		            .antMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs/swagger-config").permitAll()
//		            .antMatchers("/products/**").hasRole("ADMIN")
//		            .anyRequest().authenticated()
//		            .and()
//		            .httpBasic();
		        
		        
		        .csrf().disable()
		        .authorizeRequests().requestMatchers("/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**", "/v3/api-docs/swagger-config").permitAll()// Allow access to Swagger UI and API docs
		        .requestMatchers("/products/**").hasRole("ADMIN")
		        .anyRequest().authenticated()
		        .and()
		        .httpBasic();
		        return http.build();
		        
//	           .csrf().disable()
//	           .authorizeRequests()
//	           .anyRequest().permitAll();
		    }
		}
	 



