package com.SampleRestApplication.Demo.Service;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SampleRestApplication.Demo.Entity.UserEntity;
import com.SampleRestApplication.Demo.Repository.UserRepository;

@Service("userDetailsServiceImpl")
public class CustomerUserDetailsService implements UserDetailsService {

	private  UserRepository userRepository;
	
	public void CustomUserDetailsService(UserRepository userRepository) {
	
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = userRepository.findByUsername(username)
		    .orElseThrow(()-> new UsernameNotFoundException("user not found"));
		    
		    return new User(
		    		userEntity.getUsername(),
		    		userEntity.getPassword(),
		    		Collections.singletonList(new SimpleGrantedAuthority("ROLE_"+ userEntity.getRole()))
		    	
		    );
	}
}
