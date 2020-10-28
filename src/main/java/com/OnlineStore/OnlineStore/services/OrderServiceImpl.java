package com.OnlineStore.OnlineStore.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.OnlineStore.OnlineStore.models.entity.Order;
import com.OnlineStore.OnlineStore.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public List<Order> findAll() {
		return (List<Order>)orderRepository.findAll();
	}

	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order findById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

}
