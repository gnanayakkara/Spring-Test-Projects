package com.gnanayakkara.springsecuritylatest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gnanayakkara.springsecuritylatest.dto.AuthRequest;
import com.gnanayakkara.springsecuritylatest.dto.Product;
import com.gnanayakkara.springsecuritylatest.entity.UserInfo;
import com.gnanayakkara.springsecuritylatest.service.JwtService;
import com.gnanayakkara.springsecuritylatest.service.ProductService;

/*
 * 26 Mar 2023
 */
@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}
	
	@PostMapping("/new")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return productService.addUser(userInfo);
	}
	
	@GetMapping("/all")
	@PreAuthorize("hasAuthority('ROLE_ADMIN')")
	public List<Product> getAllProducts(){
		return productService.getProducts();
	}
	
	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_USER')")
	public Product getProductById(@PathVariable int id) {
		return productService.getProduct(id);
	}
	
	@PostMapping("/authenticate")
	public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {

		Authentication authenticate = authManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
		
		if(authenticate.isAuthenticated()) {
			return jwtService.generateToken(authRequest.getUserName());
		} else {
			throw new UsernameNotFoundException("Invalid User Request");
		}
		
	}
}
