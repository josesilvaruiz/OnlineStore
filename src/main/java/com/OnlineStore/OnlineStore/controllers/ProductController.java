package com.OnlineStore.OnlineStore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.OnlineStore.OnlineStore.models.entity.Product;
import com.OnlineStore.OnlineStore.services.IProductService;

@Controller
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	
	@GetMapping("/products")
	public List<Product> index() {
		return productService.findAll();
	}
	@PostMapping("/products")
	public String save(@ModelAttribute("productAdd") Product product) {
		productService.save(product);
		return "redirect:/product";
	}
}

