package com.SampleRestApplication.Demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.SampleRestApplication.Demo.Entity.UserEntity;
import com.SampleRestApplication.Demo.Repository.UserRepository;


@Component
public class DataInitializer {

//		@Bean
//		CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//			
//			return args ->{
//				userRepository.save(new UserEntity("admin",passwordEncoder.encode("admin123"),"ADMIN"));
//				
//			};
//		}
		
        private final UserRepository userRepository;
		private final PasswordEncoder passwordEncoder;
		
		@Autowired
		public DataInitializer(UserRepository userRepository,PasswordEncoder passwordEncoder) {
			this.userRepository = userRepository;
			this.passwordEncoder = passwordEncoder;
		}
	}


