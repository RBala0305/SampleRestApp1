package com.SampleRestApplication.Demo.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="User_details")
public class UserEntity {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private Long id;
	private String username;
	
	private String Password;
	private String role;
	
	
	public UserEntity() {
		
	}
	
	public UserEntity(String username,String password,String role) {
		this.username=username;
		this.Password=password;
		this.role=role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}

