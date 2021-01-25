package com.abhikdutta.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhikdutta.springrest.entity.Product;
import com.abhikdutta.springrest.service.IProductService;

@RestController
public class ProductController {

	@Autowired
	private IProductService productService;

	//Get all Products
	@GetMapping("/products")
	public List<Product> getProducts() {
		return productService.getProducts();
	}
	
	// Get a Product by id
	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable String productId) {
		
		return productService.getProduct(Long.parseLong(productId));
	}
	
	// Save a Product
	@PostMapping("/products")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	
	// Update a Product
	@PutMapping("/products")
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	// Delete a Product
	@DeleteMapping("/products/{productId}")
	public ResponseEntity<HttpStatus> deleteProduct(@PathVariable String productId) {
		try {
			productService.deleteProduct(Long.parseLong(productId));
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
