package com.SampleRestApplication.Demo.Service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.SampleRestApplication.Demo.Entity.ProductEntity;
import com.SampleRestApplication.Demo.Repository.ProductRepository;
import com.SampleRestApplication.Demo.Service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Page<ProductEntity> getAllProducts(int page,int size){
	     Pageable pageable =PageRequest.of(page,size);
		return productRepository.findAll(pageable);
	}
   @Override
	public List<ProductEntity> getAllProducts(){
		return productRepository.findAll();
	}
   @Override
   public Optional <ProductEntity> getProductById(Long id){
	   return productRepository.findById(id);
   }
   @Override
   public ProductEntity createProduct(ProductEntity product) {
	   product.setCreatedDate(LocalDateTime.now());
	   return productRepository.save(product);
   }
   @Override
   public ProductEntity updateProduct(Long id,ProductEntity productDetails) {
	   ProductEntity existingProduct = productRepository.findById(id)
			   .orElseThrow(()-> new RuntimeException("Product not found"));
	   
	   existingProduct.setName(productDetails.getName());
	   existingProduct.setDescription(productDetails.getDescription());
	   existingProduct.setPrice(productDetails.getPrice());
	   
	   return productRepository.save(existingProduct);
   }
   public void deleteProduct(Long id) {
	   productRepository.deleteById(id);
   }
}
