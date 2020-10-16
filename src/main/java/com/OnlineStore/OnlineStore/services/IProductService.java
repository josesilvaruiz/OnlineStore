package com.OnlineStore.OnlineStore.services;

import java.util.List;

import com.OnlineStore.OnlineStore.models.entity.Product;

public interface IProductService {
	
	public List<Product> findAll();
	
	public Product save(Product product);
	
	public Product findById(Long id);
	
	public void delete(Long id);
	
}
