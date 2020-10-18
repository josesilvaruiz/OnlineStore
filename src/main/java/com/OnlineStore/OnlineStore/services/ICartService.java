package com.OnlineStore.OnlineStore.services;



import java.util.List;

import com.OnlineStore.OnlineStore.models.entity.Cart;


public interface ICartService {
	
	public List<Cart> findAll();
	
	public Cart save(Cart cart);
	
	public Cart findById(Long id);
	
	public void delete(Long id);
}
