package com.OnlineStore.OnlineStore.services;

import java.util.List;

import com.OnlineStore.OnlineStore.models.entity.CartItem;

public interface ICartItemService {
	public List<CartItem> findAll();
	
	public CartItem save(CartItem cartItem);
	
	public CartItem findById(Long id);
	
	public void delete(Long id);
}
