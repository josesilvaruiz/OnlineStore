package com.OnlineStore.OnlineStore.services;

import java.util.List;

import com.OnlineStore.OnlineStore.models.entity.Order;

public interface IOrderService {
	public List<Order> findAll();
	
	public Order save(Order order);
	
	public Order findById(Long id);
	
	public void delete(Long id);
}
