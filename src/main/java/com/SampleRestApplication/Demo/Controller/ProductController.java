package com.SampleRestApplication.Demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SampleRestApplication.Demo.Entity.ProductEntity;
import com.SampleRestApplication.Demo.Service.ProductService;

import jakarta.validation.Valid;


@RestController
@RequestMapping
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping
	public  List<ProductEntity> getAllProducts(){
		return productService.getAllProducts();
	}
	@GetMapping("/{id}")
	public ResponseEntity<ProductEntity> getProductById(@Valid @PathVariable Long id){
		Optional<ProductEntity> product =productService.getProductById(id);
		return product.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}
	@PostMapping
	public ProductEntity createProduct(@Valid @RequestBody ProductEntity product) {
		return productService.createProduct(product);
	}
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateProduct(@PathVariable Long id,@Valid @RequestBody ProductEntity product){
		return ResponseEntity.ok(productService.updateProduct(id, product));
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
				}
	
	}
	
