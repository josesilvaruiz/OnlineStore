package com.OnlineStore.OnlineStore.services;

import java.util.List;

import com.OnlineStore.OnlineStore.models.entity.Cart;
import com.OnlineStore.OnlineStore.models.entity.Product;

public interface ICartService {
	
	public List<Product> findAll();
	
	public Cart save(Product product);
	
	public Cart findById(Long id);
	
	public void delete(Long id);
}
