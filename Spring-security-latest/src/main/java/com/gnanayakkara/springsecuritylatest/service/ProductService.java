package com.gnanayakkara.springsecuritylatest.service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Service;

import com.gnanayakkara.springsecuritylatest.dto.Product;

import jakarta.annotation.PostConstruct;

/*
 * 26 Mar 2023
 */

@Service
public class ProductService {

	List<Product> productList;

	@PostConstruct
	public void loadProductsFromDB() {

		productList = IntStream
				.rangeClosed(1, 100)
				.mapToObj(i -> Product.builder()
						.productId(i)
						.name("Product " + i)
						.qty(new Random().nextInt(10))
						.price(new Random().nextDouble(5000)).build())
				.collect(Collectors.toList());
	}
	
	public List<Product> getProducts(){
		return productList;
	}
	
	public Product getProduct(int id) {
		return productList.stream()
				.filter(p -> p.getProductId() == id)
				.findAny()
				.orElseThrow(() -> new RuntimeException("Product " + id + " not found"));
	}
}
