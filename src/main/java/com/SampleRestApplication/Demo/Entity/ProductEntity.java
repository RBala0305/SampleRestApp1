package com.SampleRestApplication.Demo.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name= "Product_Details")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message ="name is mandatory")
	private String name;
	private String description;
	
   @NotNull(message="price is mandatory")
	private Double price;
	private LocalDateTime createdDate;
	
	public Long getId() {
		return id;
	}
	public LocalDateTime getCreatedDate() {
		return createdDate;
		
	}
	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate=createdDate;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
}
