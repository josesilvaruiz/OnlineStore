package com.OnlineStore.OnlineStore.services;

import java.util.List;
import com.OnlineStore.OnlineStore.models.entity.OrderItem;

public interface IOrderItemService {
	public List<OrderItem> findAll();
	
	public OrderItem save(OrderItem orderItem);
	
	public OrderItem findById(Long id);
	
	public void delete(Long id);
}
