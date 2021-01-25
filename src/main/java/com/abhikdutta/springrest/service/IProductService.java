package com.abhikdutta.springrest.service;

import java.util.List;

import com.abhikdutta.springrest.entity.Product;

public interface IProductService {
	
	List<Product> getProducts();

	Product getProduct(long productId);
	
	Product addProduct(Product product);
	
	Product updateProduct(Product product);
	
	void deleteProduct(long productId);

}
