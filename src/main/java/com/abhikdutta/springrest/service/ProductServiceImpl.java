package com.abhikdutta.springrest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.abhikdutta.springrest.entity.Product;

@Service
public class ProductServiceImpl implements IProductService {
	
	List<Product> productList;

	public ProductServiceImpl() {
		productList = new ArrayList<>();
	}

	@Override
	public List<Product> getProducts() {
		return productList;
	}

	@Override
	public Product getProduct(long productId) {

		List<Product> retrievedProductList = productList.stream().filter(p -> p.getId() == productId)
				.collect(Collectors.toList());
		if (null != retrievedProductList && !retrievedProductList.isEmpty()) {
			return retrievedProductList.get(0);
		}
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		productList.add(product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {

		productList.forEach(p -> {
			if (p.getId() == product.getId()) {
				p.setName(product.getName());
				p.setPrice(product.getPrice());
			}
		});
		return product;
	}

	@Override
	public void deleteProduct(long productId) {
		List<Product> retrievedProductList = 
				productList.stream().filter(p -> p.getId() == productId).collect(Collectors.toList());
		if (null != retrievedProductList && !retrievedProductList.isEmpty()) {
			productList.remove(retrievedProductList.get(0)) ;
		}
		return ;
	}
	
	

}
