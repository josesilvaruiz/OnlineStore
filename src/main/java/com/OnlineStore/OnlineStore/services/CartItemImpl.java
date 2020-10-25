package com.OnlineStore.OnlineStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineStore.OnlineStore.models.entity.CartItem;
import com.OnlineStore.OnlineStore.repository.CartItemRepository;

@Service
public class CartItemImpl implements ICartItemService{
	@Autowired
	private CartItemRepository cartItemRepository;
	
	public List<CartItem> findAll() {
		return (List<CartItem>)cartItemRepository.findAll();
	}
	

	public CartItem save(CartItem cartItem) {
		return cartItemRepository.save(cartItem);
	}

	public CartItem findById(Long id) {
		return cartItemRepository.findById(id).orElse(null);
	}


	public void delete(Long id) {
	}
}