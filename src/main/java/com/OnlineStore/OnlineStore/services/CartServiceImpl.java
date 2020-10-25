package com.OnlineStore.OnlineStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineStore.OnlineStore.models.entity.Cart;
import com.OnlineStore.OnlineStore.repository.CartRepository;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public List<Cart> findAll() {
		return (List<Cart>)cartRepository.findAll();
	}
	
	@Override
	public Cart save(Cart cart) {
		return cartRepository.save(cart);
	}
	@Override
	public Cart findById(Long id) {
		
		return null;
	}

	@Override
	public void delete(Long id) {
		
	}



	

}
