package com.OnlineStore.OnlineStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OnlineStore.OnlineStore.models.entity.OrderItem;
import com.OnlineStore.OnlineStore.repository.OrderItemRepository;

@Service
public class OrderItemImpl implements IOrderItemService {
	@Autowired
	private OrderItemRepository orderItemRepository;
	@Override
	public List<OrderItem> findAll() {
		return (List<OrderItem>)orderItemRepository.findAll();
	}

	@Override
	public OrderItem save(OrderItem orderItem) {
		return orderItemRepository.save(orderItem);
	}

	@Override
	public OrderItem findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
