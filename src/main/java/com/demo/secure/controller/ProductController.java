package com.demo.secure.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.demo.secure.dto.Product;
import com.demo.secure.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}
//
//	    @PostMapping("/new")
//	    public String addNewUser(@RequestBody UserInfo userInfo){
//	        return service.addUser(userInfo);
//	    }

	@PreAuthorize("hasRole('USER')")
	@GetMapping("/all")
	// to access the security only admin
	public List<Product> getAllTheProducts() {
		return service.getProducts();
	}

	@GetMapping("/product/{id}")
	public Product getProductById(@PathVariable int id) {
		return service.getProduct(id);
	}
}
