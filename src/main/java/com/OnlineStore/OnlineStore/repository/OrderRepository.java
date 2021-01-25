package com.OnlineStore.OnlineStore.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.OnlineStore.OnlineStore.models.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long>{
	
}
