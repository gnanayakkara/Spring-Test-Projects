package com.gnanayakkara.springsecuritylatest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnanayakkara.springsecuritylatest.dto.Product;
import com.gnanayakkara.springsecuritylatest.service.ProductService;

/*
 * 26 Mar 2023
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}
	
	@GetMapping("/all")
	public List<Product> getAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	public Product getProductById(@PathVariable int id) {
		return productService.getProduct(id);
	}
}
