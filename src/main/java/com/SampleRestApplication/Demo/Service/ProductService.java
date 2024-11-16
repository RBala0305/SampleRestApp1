package com.SampleRestApplication.Demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.SampleRestApplication.Demo.Entity.ProductEntity;

public interface ProductService {

		List<ProductEntity> getAllProducts();
		
		Optional<ProductEntity> getProductById(Long id);
		
		ProductEntity createProduct(ProductEntity product);
		ProductEntity updateProduct(Long id, ProductEntity product);
		void deleteProduct (Long id);
		
		Page<ProductEntity> getAllProducts(int page,int Size);	
 		
	}


